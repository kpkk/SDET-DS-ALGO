package comparatorPractise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortCarsTestClass {

   @Test
    public void test(){
       List<ZoomCars> cars=new ArrayList<>();
       cars.add(new ZoomCars("Maruti Swift AT", "Diesel", 1258));
       cars.add(new ZoomCars("Toyoto Glanza", "Petrol", 1208));
       cars.add(new ZoomCars("Ford Ecosport", "Diesel", 1359));
       cars.add(new ZoomCars("Maruti Swift", "Diesel", 1153));
       cars.add(new ZoomCars("Tata Tiago", "Diesel", 978));

       Collections.sort(cars, new Comparator<ZoomCars>() {
           @Override
           public int compare(ZoomCars o1, ZoomCars o2) {
              if(o1.getPrice()>o2.getPrice()) return 1;
              else if(o1.getPrice()<o2.getPrice()) return -1;
              else return 0;
           }
       });
       System.out.println(cars);
       Comparator<ZoomCars> c1=(a,b)->{
           if(a.getPrice()>b.getPrice())
          return 1;
           else if(a.getPrice()<b.getPrice())
               return -1;
           else return 0;
       };

       Collections.sort(cars,c1);
       Collections.sort(cars,Comparator.comparing(ZoomCars::getPrice));
       Collections.sort(cars,(a,b)->Integer.compare(b.getPrice(),a.getPrice()));
       System.out.println(cars);

      cars = cars.stream().filter((car)->car.getType().equals("Diesel")).collect(Collectors.toList());
      Collections.sort(cars,c1);
       System.out.println(cars.get(0));
   }



}
