package org.lumenk.newdayinformation.repositories;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lumenk.newdayinformation.objects.NewDayMember;

import java.util.HashMap;
import java.util.UUID;

public class MemberRepository {
    /**
     * 플레이어 데이터를 메모리에서 저장하고 불러오기 위해 이거 쓸겁니다
     */
    private static final HashMap<UUID, NewDayMember> members = new HashMap<>();

    @Nullable
    public NewDayMember getMember(UUID uuid){
        return members.getOrDefault(uuid, null);
    }

    /**
     * NewDayMember 객체를 저장합니다
     * @param member 이름이랑 기수랑 내놔!!
     */
    public void putMember(@NotNull NewDayMember member){
        members.put(member.getPlayerUUID(), member);
    }

    public void save(){

    }

    public void load(){

    }
}
