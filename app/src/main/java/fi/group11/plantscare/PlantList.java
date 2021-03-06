package fi.group11.plantscare;

import java.util.ArrayList;

public class PlantList {
    private static final PlantList instance = new PlantList();
    private ArrayList<Plant> plants;

    public static PlantList getInstance() {
        return instance;
    }

    private PlantList() {
        this.plants = new ArrayList<>();
        plants.add(new Plant("rose", "flower", 3, "6-8 hours/day", "27°C"));
        plants.add(new Plant("sunflower", "flower", 1, "3 hours/day", "40°C"));
        plants.add(new Plant("Mum", "flower", 1, "as much as possible", "20-25°C"));
        plants.add(new Plant("Hyacinth", "flower", 5, "2-4 hours/day", "17-25°C"));
        plants.add(new Plant("Lily", "flower", 5, "5 hours/day", "10-25°C"));
        plants.add(new Plant("Tulip", "flower", 3, "4 hours/day", "10-20°C"));
        plants.add(new Plant("Balsam", "flower", 5, "3 hours/day", "20-28°C"));
        plants.add(new Plant("Canna", "flower", 6, "4 hours/day", "18-25°C"));
        plants.add(new Plant("Jasmine", "flower", 4, "3 hours/day", "21-35°C"));
        plants.add(new Plant("Sweet pea", "flower", 5, "5 hours/day", "17-25°C"));
        plants.add(new Plant("Geranium", "flower", 6, "1 hours/day", "20-28°C"));
        plants.add(new Plant("Morning-glory", "flower", 5, "3 hours/day", "18-25°C"));
        plants.add(new Plant("Cosmos", "flower", 3, "3 hours/day", "18-25°C"));
        plants.add(new Plant("Pansy", "flower", 5, "3 hours/day", "20-28°C"));
        plants.add(new Plant("Marigold", "flower", 3, "4 hours/day", "17-25°C"));
        plants.add(new Plant("Carnation", "flower", 5, "5 hours/day", "18-25°C"));
        plants.add(new Plant("Dahlia", "flower", 3, "5 hours/day", "20-28°C"));
        plants.add(new Plant("Pink", "flower", 5, "5 hours/day", "21-35°C"));
        plants.add(new Plant("Crocus", "flower", 2, "4 hours/day", "18-25°C"));
        plants.add(new Plant("Iris", "flower", 10, "4 hours/day", "18-25°C"));
        plants.add(new Plant("Daffodil", "flower", 5, "3 hours/day", "15-22°C"));
        plants.add(new Plant("Gladiolus", "flower", 4, "4 hours/day", "20-28°C"));
        plants.add(new Plant("Magnolia", "flower", 2, "3 hours/day", "17-25°C"));
        plants.add(new Plant("Yucca", "flower", 3, "5 hours/day", "21-35°C"));
        plants.add(new Plant("Camellia", "flower", 5, "5 hours/day", "15-22°C"));
        plants.add(new Plant("Orchid", "flower", 2, "3 hours/day", "20-28°C"));
        plants.add(new Plant("Begonia", "flower", 4, "2 hours/day", "21-34°C"));
        plants.add(new Plant("Redbud", "flower", 5, "1 hours/day", "18-25°C"));
        plants.add(new Plant("Peony", "flower", 1, "2 hours/day", "21-35°C"));
        plants.add(new Plant("Daphne", "flower", 5, "3 hours/day", "18-25°C"));
        plants.add(new Plant("Gardenia", "flower", 6, "4 hours/day", "17-25°C"));
        plants.add(new Plant("Poplar", "tree", 4, "as much as possible", "18-25°C"));
        plants.add(new Plant("Cottonwood", "tree", 5, "as much as possible", "15-22°C"));
        plants.add(new Plant("Osier", "tree", 7, "as much as possible", "25-30°C"));
        plants.add(new Plant("Willow", "tree", 5, "as much as possible", "21-35°C"));
        plants.add(new Plant("Birch", "tree", 8, "as much as possible", "20°C"));
        plants.add(new Plant("Maple", "tree", 10, "6 hours/day", "20°C"));
        plants.add(new Plant("Sequoia", "tree", 6, "5 hours/day", "20-28°C"));
        plants.add(new Plant("Hemlock", "tree", 5, "6 hours/day", "18-28°C"));
        plants.add(new Plant("Rosewood", "tree", 8, "6 hours/day", "28°C"));
        plants.add(new Plant("Spruce", "tree", 7, "as much as possible", "16-28°C"));
        plants.add(new Plant("Yew", "tree", 5, "as much as possible", "15-30°C"));
        plants.add(new Plant("Eucalytus", "tree", 7, "6 hours/day", "25-32°C"));
        plants.add(new Plant("Locust", "tree", 6, "6 hours/day", "21-35°C"));
        plants.add(new Plant("Wattle", "tree", 6, "as much as possible", "18-28°C"));
        plants.add(new Plant("Ebony", "tree", 4, "7 hours/day", "25-30°C"));
        plants.add(new Plant("Oak", "tree", 6, "as much as possible", "20-32°C"));
        plants.add(new Plant("Teak", "tree", 6, "4 hours/day", "20-28°C"));
        plants.add(new Plant("Elm", "tree", 7, "5 hours/day", "18-26°C"));
        plants.add(new Plant("Ginkgo", "tree", 8, "as much as possible", "15-25°C"));
        plants.add(new Plant("Holly", "tree", 10, "4 hours/day", "32°C"));
        plants.add(new Plant("Cycad", "tree", 9, "5 hours/day", "20-28°C"));
        plants.add(new Plant("Oil-plam", "tree", 6, "as much as possible", "21-35°C"));
    }

    public ArrayList<Plant> getPlants() {
        return this.plants;
    }
}
