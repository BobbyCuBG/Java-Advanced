package _06_DefiningClasses.Exercise._07_Google;

import java.util.List;

public class Person {
    private final String name;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pokemon = null;
        this.parents = null;
        this.children = null;
        this.car = null;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
