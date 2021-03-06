package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain_8 {

    public static void main(String[] args) {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = enf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member_17 member = new Member_17();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team_17 team = new Team_17();
//            team.setName("TeamA");
//            team.getMembers().add(member);
//            em.persist(team);

            Team_8 team = new Team_8();
            team.setName("TeamA");
            //team.getMembers().add(member);
            em.persist(team);

            Member_8 member = new Member_8();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

//            team.getMembers().add(member);

//            em.flush();
//            em.clear();

            Team_8 findTeam = em.find(Team_8.class, team.getId());
            List<Member_8> members = findTeam.getMembers();

            System.out.println("===================");
            for (Member_8 m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        enf.close();

    }
}
