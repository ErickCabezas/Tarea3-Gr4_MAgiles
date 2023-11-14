package entity;
import jakarta.persistence.*;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            TypedQuery<UsuarioEntity> consultaUsuariosQuery = entityManager.createNamedQuery("Usuario.usuarios", UsuarioEntity.class);
            for(UsuarioEntity usuario: consultaUsuariosQuery.getResultList()){
                System.out.println(usuario.toString());
            }
            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
