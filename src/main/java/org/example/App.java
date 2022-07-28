package org.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
public class App 
{
    static int init = 1;
    static int fin = 5;
    public static void main( String[] args )
    {
//        sesionOne();
//        sesionTwo();
//        exercises();
//        createObservable();
//        createObservableJust();
//        createObservableFromIterable();
//        createObservableRange();
//        createObservableInterval();
//        createObservableDefer();
//        multiCasting();
        exercise();
    }

    public static void sesionOne() {
        FunctionalInterface myInterface = () -> System.out.println("Processing");
        myInterface.print("Hola");
        Function<Long, Long> adder = new AddThree();
        long result = adder.apply(4L);
        System.out.println(result);

        Function<Long, Long> adderLambda = (item) -> item + 3L;
        long resultLambda = adderLambda.apply(4L);
        System.out.println(resultLambda);

        Predicate<Object> isNull = (item) -> item == null;
        boolean resultPredicate = isNull.test(null);
        System.out.println(resultPredicate);

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add = (value) -> value + 3;
        Function<Integer, Integer> substract = (value) -> value - 1;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);
        Integer resultCompose = addThenMultiply.apply(2);
        System.out.println(resultCompose);

        Function<Integer, Integer> addThenMultiplyThenSubstract = addThenMultiply.andThen(substract);
        Integer resultThen = addThenMultiplyThenSubstract.apply(2);
        System.out.println(resultThen);

        Author aut01 = new Author("andres", 21, Gender.MALE);
        Author aut02 = new Author("andrea", 23, Gender.FEMALE);
        Author aut03 = new Author("julio", 25, Gender.MALE);
        Author aut04 = new Author("julia", 29, Gender.FEMALE);
        Author aut05 = new Author("camilo", 33, Gender.MALE);
        Author aut06 = new Author("camila", 35, Gender.FEMALE);
        Author aut07 = new Author("juan", 37, Gender.MALE);
        Author aut08 = new Author("juana", 39, Gender.FEMALE);
        Author aut09 = new Author("fernando", 41, Gender.MALE);
        Author aut10 = new Author("fernanda", 43, Gender.FEMALE);
        Author aut11 = new Author("carlos", 45, Gender.MALE);
        Book book01 = new Book(aut01);
        Book book02 = new Book(aut01);
        Book book03 = new Book(aut02);
        Book book04 = new Book(aut03);
        Book book05 = new Book(aut05);
        Book book06 = new Book(aut08);
        Book book07 = new Book(aut02);
        Book book08 = new Book(aut10);
        Book book09 = new Book(aut11);
        Book book10 = new Book(aut04);
        Book book11 = new Book(aut07);
        Book book12 = new Book(aut09);
        Book book13 = new Book(aut08);
        Book book14 = new Book(aut07);
        Book book15 = new Book(aut06);
        Book book16 = new Book(aut05);
        Book book17 = new Book(aut04);
        Book book18 = new Book(aut03);
        Book book19 = new Book(aut02);
        Book book20 = new Book(aut01);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book01);
        books.add(book02);
        books.add(book03);
        books.add(book04);
        books.add(book05);
        books.add(book06);
        books.add(book07);
        books.add(book08);
        books.add(book09);
        books.add(book10);
        books.add(book11);
        books.add(book12);
        books.add(book13);
        books.add(book14);
        books.add(book15);
        books.add(book16);
        books.add(book17);
        books.add(book18);
        books.add(book19);
        books.add(book20);
        Predicate<Author> filterGender = (author) -> author.getGender().equals(Gender.FEMALE);
        Predicate<Integer> filterAge = (age) -> age < 25;
        Integer ans = books.stream()
                .map(Book::getAuthor)
                .distinct()
                .filter(filterGender)
                .map(Author::getAge)
                .filter(filterAge)
                .reduce(0, Integer::sum);
        System.out.println(ans);

        List<List<Integer>> listaBidimensional = new ArrayList<List<Integer>>(
                Arrays.asList(
                        new ArrayList<Integer>(Arrays.asList(1, 2)),
                        new ArrayList<Integer>(Arrays.asList(3, 4))
                )
        );// [// [1, 2],// [3, 4]// ]

        List<Integer> listaAplanada = listaBidimensional.stream()
                .flatMap( listaInterna -> listaInterna.stream())
                .collect(toList());

        for (Integer n : listaAplanada) {System.out.println(n);}
    }

    public static void sesionTwo() {
        new SimplePublisher(10).subscribe(new Flow.Subscriber<Integer>() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {

            }

            @Override
            public void onNext(Integer item) {
                System.out.println("item = [" + item + "]");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });
    }

    public static void exercises() {
        //ejercicio uno
        String name1 = "Andres Felipe Castro Malaver";
        String name2 = "Felipe Castro Malaver";
        List<String> names = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        List<String> ansf = names.stream()
                .map(x -> x.split(" ")[0])
                .map(x -> x.toUpperCase()).collect(toList());
        System.out.println(ansf.toString());

        //ejercicio dos
        Empleado emp01 = new Empleado(1, "Andres", 18, 2000000, "Cundinamarca");
        Empleado emp02 = new Empleado(2, "Andrea", 25, 2500000, "Cundinamarca");
        Empleado emp03 = new Empleado(3, "Camilo", 33, 3000000, "Valle del Cauca");
        Empleado emp04 = new Empleado(4, "Camila", 39, 3500000, "Antioquia");
        Empleado emp05 = new Empleado(5, "Juan", 40, 4000000, "Antioquia");
        Empleado emp06 = new Empleado(6, "Juana", 45, 4500000, "Cundinamarca");
        Empleado emp07 = new Empleado(7, "Santiago", 62, 5000000, "Boyaca");

        List<Empleado> empleados = Arrays.asList(emp01, emp02, emp03, emp04, emp05, emp06, emp07);

        empleados.stream()
                .filter(x -> x.getEdad() >= 25 && x.getEdad() <= 30)
                .forEach(System.out::println);

        //ejercicio tres
        OptionalDouble averageSalary = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average();

        System.out.println(averageSalary.getAsDouble());

        Long countEmpleado = empleados.stream()
                .filter(x ->  x.getSalario() <= averageSalary.getAsDouble())
                .count();
        System.out.println(countEmpleado);

        //ejercicio cuatro
        Optional<Empleado> emp = empleados.stream()
                .filter(x -> x.getDepartamento().equals("Cundinamarca"))
                .max(Comparator.comparing(Empleado::getSalario));
        System.out.println(emp.toString());

        //ejercicio cinco
        Map<String, List<Empleado>> empGrp = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.toList()));
        System.out.println(empGrp.toString());
    }

    public static void createObservable() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("uno");
                emitter.onNext("dos");
                emitter.onNext("tres");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source.subscribe(s -> System.out.println("Numero recibido: " + s), Throwable::printStackTrace);
    }

    public static void createObservableJust() {
        Observable<String> source = Observable.just("uno", "dos", "tres");
        source.subscribe(s -> System.out.println("Numero recibido: " + s));
    }

    public static void createObservableFromIterable() {
        List<String> items = Arrays.asList("uno", "dos", "tres");
        Observable<String> source = Observable.fromIterable(items);
        source.subscribe(s -> System.out.println("Numbero recibido: " + s));
    }

    public static void createObservableRange() {
        Observable.range(1, 10)
                .subscribe(s -> System.out.println("Rango recibido: " + s));
    }

    public static void createObservableInterval() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " Mississippi"));
    }

    public static void createObservableDefer() {
        Observable<Integer> source = Observable.defer(() -> Observable.range(init, fin));
        source.subscribe(i -> System.out.println("Observer 1: " + i));
        fin = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    public static void multiCasting() {
        Observable<String> observable = Observable.just("Event")
                .publish()
                .autoConnect(2)
                .map(s -> {
                    System.out.println("Expensive operation for " + s);
                    return s;
                });
        observable.subscribe(s -> System.out.println("Sub 1 got: " + s));
        observable.subscribe(s -> System.out.println("Sub 2 got: " + s));

        Observable<String> observable2 = Observable.just("Event")
                .map(s -> {
                    System.out.println("Expensive operation for " + s);
                    return s;
                })
                .publish()
                .autoConnect(2);
        observable2.subscribe(s -> System.out.println("Sub 1 got: " + s));
        observable2.subscribe(s -> System.out.println("Sub 2 got: " + s));
    }

    public static void exercise() {
        int[] arr1 = new int[]{1000, 2000, 3000};
        int[] arr2 = new int[]{2000, 3000, 4000, 5000};
        ArrayList<Integer> ventasD1 = new ArrayList<>(Arrays.asList(1000, 2000, 3000));
        ArrayList<Integer> ventasKoaj = new ArrayList<>(Arrays.asList(2000, 3000, 4000, 5000));

    }
}