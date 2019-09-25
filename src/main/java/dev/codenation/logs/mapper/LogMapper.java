package dev.codenation.logs.mapper;

import dev.codenation.logs.domain.entity.Log;
import dev.codenation.logs.dto.LogFilterDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface LogMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "hash", target = "hash"),
            @Mapping(source = "message", target = "logDetailVO.message"),
            @Mapping(source = "details", target = "logDetailVO.details"),
            @Mapping(source = "getSeverityENUM", target = "logDetailVO.severityENUM"),
            @Mapping(source = "getEnvironmentENUM", target = "originVO.environmentENUM"),
            @Mapping(source = "origin", target = "originVO.origin"),
            @Mapping(source = "archived", target = "archived"),
            @Mapping(source = "archivedBy", target = "archivedBy.id"),
            @Mapping(source = "reportedBy", target = "reportedBy.id")
    })
    Log map(LogFilterDTO filter);

//    @Named("optionalWrapper")
//    default <T> T optionalWrapper(Optional<T> optional) {
//        return optional.orElse(null);
//    }
}
