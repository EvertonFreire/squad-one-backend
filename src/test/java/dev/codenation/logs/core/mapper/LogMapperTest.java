package dev.codenation.logs.core.mapper;

import dev.codenation.logs.domain.entity.Log;
import dev.codenation.logs.domain.enums.Environment;
import dev.codenation.logs.domain.enums.Severity;
import dev.codenation.logs.core.dto.request.LogFilterRequestDTO;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogMapperTest {

    @Autowired
    private LogMapper mapper;

    private UUID id_user = UUID.randomUUID();

    private UUID id_log = UUID.randomUUID();

    @Test
    public void WhenMapLogFilterRequestDTO_ReturnLog(){

        LogFilterRequestDTO request = createLogFilterRequestDTO();

        Log log = mapper.map(request);

        assertThat(log.getId(), Matchers.equalTo(id_log));
        assertThat(log.getHash().toString(), Matchers.equalTo("-1675388953"));
        assertThat(log.getLogDetail().getDetails(), Matchers.equalTo("Details"));
        assertThat(log.getArchived(), Matchers.equalTo(Boolean.TRUE));
        assertThat(log.getArchivedBy().getId(), Matchers.equalTo(id_user));
        assertThat(log.getOrigin().getEnvironment(), Matchers.equalTo(Environment.DEV));
        assertThat(log.getLogDetail().getMessage(), Matchers.equalTo("Message"));
        assertThat(log.getOrigin().getOrigin(), Matchers.equalTo("Origin"));
        assertThat(log.getReportedBy().getId(), Matchers.equalTo(id_user));
        assertThat(log.getLogDetail().getSeverity(), Matchers.equalTo(Severity.WARNING));
    }


    private LogFilterRequestDTO createLogFilterRequestDTO() {
        return LogFilterRequestDTO.builder()
                .id(id_log)
                .details("Details")
                .archived(Boolean.TRUE)
                .archivedBy(id_user)
                .environment(Environment.DEV)
                .message("Message")
                .origin("Origin")
                .reportedBy(id_user)
                .severity(Severity.WARNING)
                .build();
    }

}
