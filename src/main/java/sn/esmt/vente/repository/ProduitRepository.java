package sn.esmt.vente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.esmt.vente.entity.ProduitEntity;

import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<ProduitEntity,String> {
  
  @Query("select p from ProduitEntity p where p.ref=?1 and p.nom=?2")
  public Optional<ProduitEntity> FindByReferenceAndNom(String ref,String nom);

  @Query("select p from ProduitEntity p where p.ref= :r and p.nom= :n")
  public Optional<ProduitEntity> FindByReferenceAndNomV2(@Param("r") String ref,@Param("n") String nom);

  public Optional<ProduitEntity>findByRef(String ref);
}
