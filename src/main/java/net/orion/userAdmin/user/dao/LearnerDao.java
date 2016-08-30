package net.orion.userAdmin.user.dao;

import net.orion.userAdmin.user.domain.Learner;

import java.util.List;

public interface LearnerDao {

    void saveLearner(Learner learner);

    List<Learner> findAllLearners();

    void deleteLearnerById(long id);

    Learner findLearnerById(long id);

    void updateLearner(Learner learner);

    Learner findLearnerByLogin(String login);

}
