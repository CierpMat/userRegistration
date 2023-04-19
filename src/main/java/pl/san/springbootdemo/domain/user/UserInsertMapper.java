package pl.san.springbootdemo.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.san.springbootdemo.domain.roles.RoleMapper;

@Mapper(uses = {UserMapper.class, RoleMapper.class})
public interface UserInsertMapper {
    UserInsertMapper INSTANCE = Mappers.getMapper(UserInsertMapper.class);

    UserInsertDTO toDTO(User user);

    User toEntity(UserInsertDTO userInsertDTO);
}
