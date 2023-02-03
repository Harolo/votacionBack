package com.votacion.Repository;

import com.votacion.Dto.RespuestaDto;
import com.votacion.Entity.VotarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VotarRepository extends JpaRepository<VotarEntity, Long>{

    @Query(value = " SELECT c.can_cedula AS cedula, COUNT( * ) AS veces "
            + " FROM votar t, candidato c "
            + " WHERE c.can_cargo=:cargo AND c.id=t.candidato_id "
            + " GROUP BY candidato_id "
            + " HAVING veces = ( "
            + " SELECT COUNT( * ) maximo "
            + " FROM votar "
            + " GROUP BY candidato_id "
            + " ORDER BY maximo DESC "
            + " LIMIT 1 );", nativeQuery = true)
    RespuestaDto data(@Param("cargo") String cargo);
}
