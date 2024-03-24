package org.sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.sda.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            // Database operations
            try {
                // Set properties of the entity
                System.out.println("Success");
                Name name1 = new Name("John", "Doe");
                Person person1 = new Person(name1);

                Name name2 = new Name("Eva", "Doe");
                Person person2 = new Person(name2);

                // Example: Saving an object to the database
                session.save(person1);
                session.save(person2);

                // Creating birds
                Bird bird1 = new Bird("Canary", true, 20);
                Bird bird2 = new Bird("Ostrich", false, 140_000);
                Bird bird3 = new Bird("Parrot", true, 500);

                session.save(bird1);
                session.save(bird2);
                session.save(bird3);

                // Creating habitat
                Habitat habitat = new Habitat("Forest", "North America");
                session.save(habitat);

                bird1.setHabitat(habitat);
                // Save birds with updated habitat
                session.save(bird1);

                // Creating nests
                Nest nest1 = new Nest("Nice Nest", 5, "Wood");
                Nest nest2 = new Nest("better Nest", 10, "Hay");
                session.save(nest1);
                session.save(nest2);

                bird1.setNest(nest1);
                bird2.setNest(nest1);
                bird3.setNest(nest2);

                // Save birds with updated nest
                session.save(bird1);
                session.save(bird2);
                session.save(bird3);

                // Create foods
                Food food1 = new Food("Sunflower", 580);
                Food food2 = new Food("Golden millet", 350);

                session.save(food1);
                session.save(food2);

                List<Food> foods = new ArrayList<>();
                foods.add(food1);
                foods.add(food2);

                // Save changes
                bird1.setFoods(foods);
                session.save(bird1);

            }catch (Exception ex){
                // Rollback the transaction if an exception occurs
                transaction.rollback();
                System.out.println("Transaction rolled back due to exception: " + ex.getMessage());
            }

            // Commit the transaction if successful
            transaction.commit();
        }catch (Exception ex){
            // Handle exceptions related to opening or closing session
            System.out.println("An error occurred while opening or closing the session: " + e.getMessage());
        }
    }
}
