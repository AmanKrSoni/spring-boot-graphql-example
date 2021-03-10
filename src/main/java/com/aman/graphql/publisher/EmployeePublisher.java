package com.aman.graphql.publisher;

import com.aman.graphql.entity.Employee;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Here it uses Reactive spring dependency to emit events on saveEmployee
 */
@Slf4j
@Component
public class EmployeePublisher {

    private final Flowable<Employee> publisher;

    private ObservableEmitter<Employee> emitter;

    public EmployeePublisher() {
        Observable<Employee> commentUpdateObservable = Observable.create(emitter -> {
            this.emitter = emitter;
        });

        ConnectableObservable<Employee> connectableObservable = commentUpdateObservable.share().publish();
        connectableObservable.connect();

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void publish(final Employee employee){
        emitter.onNext(employee);
    }

    public Flowable<Employee> getPublisher(){
        return publisher;
    }
}
