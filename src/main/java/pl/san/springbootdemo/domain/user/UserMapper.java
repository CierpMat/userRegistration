package pl.san.springbootdemo.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.san.springbootdemo.domain.address.AddressMapper;

@Mapper(uses = {AddressMapper.class})  //dla zagniezdzonych tych pol z adresem uzyl mappera do adresow
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);  //metoda ktora generuje instancje tego mappera

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
