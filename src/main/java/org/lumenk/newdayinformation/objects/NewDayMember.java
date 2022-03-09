package org.lumenk.newdayinformation.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class NewDayMember {
    private final UUID playerUUID;
    private final String name;
    private final Integer order;
}
