package pl.san.springbootdemo.domain.roles;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleEntity toEntity(RoleDTO roleDTO);

    RoleDTO toDTO(RoleEntity roleEntity);

}
