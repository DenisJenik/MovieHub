

public interface ExperienceStrategy {
    public int calculateExperience();
}

class requestStrategy implements ExperienceStrategy {
    @Override
    public int calculateExperience() {
        return 1;
    }
}

class ratingStrategy implements ExperienceStrategy {
    @Override
    public int calculateExperience() {
        return 3;
    }
}

class contributionStrategy implements ExperienceStrategy {
    @Override
    public int calculateExperience() {
        return 5;
    }
}