package net.orion.userAdmin.user.service;

import net.orion.userAdmin.user.dao.LearnerDao;
import net.orion.userAdmin.user.domain.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("learnerService")
@Transactional
public class LearnerServiceImpl implements LearnerService {

    @Autowired
    private LearnerDao dao;

    public void saveLearner(Learner learner) {
        dao.saveLearner(learner);
    }

    public List<Learner> findAllLearners() {
        return dao.findAllLearners();
    }

    public void deleteLearnerById(long id) {
        dao.deleteLearnerById(id);
    }

    public Learner findLearnerById(long id) {
        return dao.findLearnerById(id);
    }

    public void updateLearner(Learner learner) {
        dao.updateLearner(learner);
    }

    public Learner findLearnerByLogin(String login) {
        return dao.findLearnerByLogin(login);
    }

    @Override
    public boolean isLearnerExist(Learner learner) {
        return findLearnerByLogin(learner.getLogin()) != null;
    }

}
