package org.lumenk.newdayinformation.repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lumenk.newdayinformation.objects.NewDayMember;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class MemberRepository {


    private static final String PLUGIN_PATH = "plugins/NewDayMembers";
    private static final String FILE_NAME = "data.json";

    /**
     * 플레이어 데이터를 메모리에서 저장하고 불러오기 위해 이거 쓸겁니다
     */
    private static final HashMap<UUID, NewDayMember> members = new HashMap<>();

    @Nullable
    public static NewDayMember getMember(@NotNull UUID uuid){
        return members.getOrDefault(uuid, null);
    }

    /**
     * NewDayMember 객체를 저장합니다
     * @param member 이름이랑 기수랑 내놔!!
     */
    public static void putMember(@NotNull NewDayMember member){
        members.put(member.getPlayerUUID(), member);
    }

    public static void save(){
        final String FILE_PATH = PLUGIN_PATH + "/" + FILE_NAME;
        Set<UUID> uuids = members.keySet();

        ArrayList<NewDayMember> memberList = new ArrayList<>();

        for(UUID uuid : uuids){
            memberList.add(getMember(uuid));
        }

        NewDayMember[] members = memberList.toArray(new NewDayMember[0]);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(members);
        //Bukkit.getLogger().info(json);
        try {
            Files.writeString(Path.of(FILE_PATH), json, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace(); //분명히 create 시켰는데 에러나면 안되는겁니다. 아마...도..
        }

    }

    public static void load(){
        members.clear();
        String json = "[]";
        final String FILE_PATH = PLUGIN_PATH + "/" + FILE_NAME;
        try {
            json = Files.readString(Path.of(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();


            File dir = new File(PLUGIN_PATH);
            dir.mkdirs();
        }

        Gson gson = new Gson();
        NewDayMember[] membersArr = gson.fromJson(json, NewDayMember[].class);
        for(int i = 0; i < membersArr.length; i++)
            putMember(membersArr[i]);



    }

}
