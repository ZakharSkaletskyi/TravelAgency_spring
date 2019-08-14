package museum.dao;

import museum.dto.response.hall.HallDtoResponse;
import museum.entity.Hall;

import java.util.List;

public interface HallDao extends ElementDao<Hall> {

    List<Hall> findHalLByWorkerId(Long workerId);

}
