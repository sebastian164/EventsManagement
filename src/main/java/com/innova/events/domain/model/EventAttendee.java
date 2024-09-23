package com.innova.events.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
@Table("event_attendees")
public class EventAttendee {
    @Id
    private Long id;
    @Column("event_id")
    private Long eventId;
    @Column("user_id")
    private Long userId;
    private Boolean attended = false;
}