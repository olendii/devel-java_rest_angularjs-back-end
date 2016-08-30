package net.orion.userAdmin.user.service;

import net.orion.userAdmin.user.domain.Learner;

import java.util.List;

public interface LearnerService {

    void saveLearner(Learner learner);

    List<Learner> findAllLearners();

    void deleteLearnerById(long id);

    Learner findLearnerById(long id);

    void updateLearner(Learner learner);

    Learner findLearnerByLogin(String login);

    boolean isLearnerExist(Learner learner);

}
