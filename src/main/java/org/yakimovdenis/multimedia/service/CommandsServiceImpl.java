package org.yakimovdenis.multimedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;
import org.yakimovdenis.multimedia.models.DBEntity;
import org.yakimovdenis.multimedia.models.MediaType;

import java.util.*;

@Service
@ShellComponent
public class CommandsServiceImpl {

    @Autowired
    private DBEntitysService dbEntitysService;

    @Autowired
    private GenresService genresService;

    @ShellMethod("Translate text from one language to another.")
    public void manager(@ShellOption String command,
                        @ShellOption(defaultValue = "") String argument1,
                        @ShellOption(defaultValue = "") String argument2){
        String[] data = new String[2];
        data[0]=argument1;
        data[1]=argument2;

        String result = null;
        switch (command) {
            case "print": {
                result = print(data);
                break;
            }
            case "add": {
                break;
            }
            case "status": {
                break;
            }
            case "remove": {
                break;
            }
            case "edit": {
                break;
            }
            case "exit": {
                System.out.println("Exiting...");
                System.exit(0);
            }
            default: {
                System.out.println("Command is wrong, please check readme");
            }
        }
        System.out.println(result);
    }

    private String print(String... strings) {
       boolean sort = false;
       String command;
       String data = null;
        if (strings[0]=="-s"){
            sort = true;
            command = strings[1];
            if (strings.length>2){
                data = strings[2];
            }
        } else {
            command = strings[0];
            if (strings.length>1){
                data = strings[1];
            }
        }
        switch (command) {
            case "games": {
                return serialization(getEntitiesAction(MediaType.GAME, sort, data));
            }
            case "movies": {
                return serialization(getEntitiesAction(MediaType.MOVIE, sort, data));
            }
            case "books": {
                return serialization(getEntitiesAction(MediaType.BOOK, sort, data));
            }
        }
        return "Wrong search command";
    }

    private List<DBEntity> getEntitiesAction(MediaType type, boolean sort, String data) {
        System.out.println(type);
        System.out.println(sort);
        System.out.println(data);
        List<DBEntity> result;
        if (data.equals("")) {
            if (sort){
                List<DBEntity> list = dbEntitysService.getAllWithType(type);
                result = Collections.sort(list, new Comparator<DBEntity>() {
                    @Override
                    public int compare(DBEntity o1, DBEntity o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }
            result =
        } else {
            result = new ArrayList<>();
            result.add(dbEntitysService.getEntityByName(data));
        }
        return result;
    }

    private String serialization(List<DBEntity> entities){
        StringBuilder builder = new StringBuilder("SEARCH RESULTS:");
        for (DBEntity entity:entities){
            builder.append('\n').append("ID=").append(entity.getId()).append('\n').append("NAME=").append(entity.getName()).append('\n').append("AUTHOR=").append(entity.getAuthor()).append('\n').append("CREATED=").append(entity.getCreationDate()).append('\n').append("STATUS=").append(entity.getStatus());
        }
        return builder.toString();
    }

}
