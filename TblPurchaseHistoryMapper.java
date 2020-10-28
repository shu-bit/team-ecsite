package jp.co.internous.cepheus.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.cepheus.model.domain.dto.PurchaseHistoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblPurchaseHistoryMapper {
	int insert(Map<String, Object> parameter);
	
	List<PurchaseHistoryDto> findByUserId(@Param("userId") int userId);
	
	@Update("UPDATE tbl_purchase_history SET status = 0, updated_at = now() WHERE user_id = #{userId}")
	int logicalDeleteByUserId(@Param("userId") int userId);
}
