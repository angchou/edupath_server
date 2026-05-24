package com.example.server.utils;

import com.example.server.actions.CourseActions;
import com.example.server.status.CourseStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CourseStatusControl {
    private static final Map<CourseActions, Set<CourseStatus>> DISABLE_RULES = new HashMap<>();

    static {
        DISABLE_RULES.put(
                CourseActions.MARK_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.PRIVATE,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.UNMARK_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.PRIVATE,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.REJECT_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED,
                        CourseStatus.PUBLIC
                )
        );

        DISABLE_RULES.put(
                CourseActions.DELETE_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED
                )
        );

        DISABLE_RULES.put(
                CourseActions.ENROLL,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED
                )
        );

        DISABLE_RULES.put(
                CourseActions.GET_DEMO,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED
                )
        );

        DISABLE_RULES.put(
                CourseActions.BAN_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE
                )
        );

        DISABLE_RULES.put(
                CourseActions.UNBAN_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED,
                        CourseStatus.PUBLIC
                )
        );

        DISABLE_RULES.put(
                CourseActions.PUBLIC_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED,
                        CourseStatus.PUBLIC
                )
        );

        DISABLE_RULES.put(
                CourseActions.GET_LESSON,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED
                )
        );

        DISABLE_RULES.put(
                CourseActions.GET_RESOURCE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED
                )
        );

        DISABLE_RULES.put(
                CourseActions.CREATE_LESSON,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.CREATE_RESOURCE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.DELETE_LESSON,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.DELETE_RESOURCE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.UPDATE_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.UPDATE_LESSON,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.UPDATE_RESOURCE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN
                )
        );

        DISABLE_RULES.put(
                CourseActions.REQUEST_OPEN,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.PUBLIC
                )
        );

        DISABLE_RULES.put(
                CourseActions.LOCK_COURSE,
                Set.of(
                        CourseStatus.DELETED,
                        CourseStatus.BANNED,
                        CourseStatus.WAITING_PUBLIC,
                        CourseStatus.REQUEST_OPEN,
                        CourseStatus.PRIVATE,
                        CourseStatus.LOCKED
                )
        );
    }

    public static boolean isDisabled(CourseActions action, Integer tinhTrang) {
        CourseStatus status = getStatusName(tinhTrang);
        return DISABLE_RULES
                .getOrDefault(action, Collections.emptySet())
                .contains(status);
    }

    private static CourseStatus getStatusName(Integer status) {
        if (status == 0) return CourseStatus.DELETED;
        else if (status == 1) return CourseStatus.BANNED;
        else if (status == 2) return CourseStatus.PRIVATE;
        else if (status == 3) return CourseStatus.REQUEST_OPEN;
        else if (status == 4) return CourseStatus.WAITING_PUBLIC;
        else if (status == 5) return CourseStatus.LOCKED;
        else if (status == 6) return CourseStatus.PUBLIC;
        return null;
    }

}
