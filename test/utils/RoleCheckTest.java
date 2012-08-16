package utils;

import models.Role;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;
import models.ModelTest;
import models.enumeration.Operation;
import models.enumeration.Resource;

public class RoleCheckTest extends ModelTest<Role>{
    @Test
    public void roleCheck() throws Exception {
        // Given
        Long userSessionId1 = 1l;
        Long userSessionId2 = 2l;
        Long projectId1 = 1l;
        Long projectId2 = 3l;
        // When

        boolean result1 = RoleCheck.permissionCheck(userSessionId1, projectId1, Resource.PROJECT_SETTING, Operation.WRITE);
        boolean result2 = RoleCheck.permissionCheck(userSessionId2, projectId2, Resource.BOARD_POST, Operation.READ);

        // Then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(false);
    }
}