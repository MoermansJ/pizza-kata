package be.pizza.kata.pizzaorder.adapter.repository;

import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderEntity;
import be.pizza.kata.pizzaorder.usecase.repository.PizzaOrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaOrderRepositoryFacade implements PizzaOrderRepository {
    private final JpaPizzaOrderRepository jpaRepo;

    public PizzaOrderRepositoryFacade(JpaPizzaOrderRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public PizzaOrderEntity save(PizzaOrderEntity entity) {
        return jpaRepo.save(entity);
    }
}
