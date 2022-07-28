package org.facturas;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observables.GroupedObservable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String ... args) {
        calculateAverage();
        //howWorksBuffer();
    }

    private static void howWorksBuffer() {
        String[] test = new String[] {"Joe", "Jane", "John", "Phil"};
        Observable.fromArray(test).toList().subscribe((list) -> System.out.println(list));
    }

    private static void calculateAverage() {
        List<BillWeek> bills = generateBills();
        Observable<BillWeek> obs1 = Observable.fromIterable(bills);
        Observable<GroupedObservable<String, BillWeek>> obs2 = obs1.groupBy(BillWeek::getCompany);
        Observable<Double> obs3 = obs2.flatMap(obs -> obs.buffer(10).map(list -> list.stream().mapToDouble(item -> item.getValue()).average().getAsDouble()));
        obs3.subscribe(s -> System.out.println(s));
    }

    private static List<BillWeek> generateBills() {
        List<BillWeek> bills = new ArrayList<>();
        bills.add(BillWeek.builder().company("D1").value(5000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(3000000D).build());
        bills.add(BillWeek.builder().company("D1").value(1000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(4000000D).build());
        bills.add(BillWeek.builder().company("D1").value(6000000D).build());
        bills.add(BillWeek.builder().company("D1").value(9000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(4000000D).build());
        bills.add(BillWeek.builder().company("D1").value(5000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(9000000D).build());
        bills.add(BillWeek.builder().company("D1").value(8000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(7000000D).build());
        bills.add(BillWeek.builder().company("D1").value(8000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(5000000D).build());
        bills.add(BillWeek.builder().company("D1").value(6000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(4000000D).build());
        bills.add(BillWeek.builder().company("D1").value(3000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(2000000D).build());
        bills.add(BillWeek.builder().company("D1").value(9000000D).build());
        bills.add(BillWeek.builder().company("Koaj").value(2000000D).build());
        return bills;
    }
}