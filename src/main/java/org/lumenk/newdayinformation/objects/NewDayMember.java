package org.lumenk.newdayinformation.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * 플레이어UUID, 실명, 기수에 대한 정보를 담아둡니다
 */
@AllArgsConstructor
@Builder
@Getter
public class NewDayMember {
    /**
     * 마인크래프트 플레이어 UUID입니다. 각종 연산의 기준이 됩니다
     */
    @NotNull
    private final UUID playerUUID;

    /**
     * 실명입니다. 개인정보 취급 동의서 받게 생겼네
     */
    @NotNull
    private final String name;

    /**
     * 이 분은 몇 기 입니까?
     */
    @NotNull
    private final Integer order;
}
