package org.yakimovdenis.multimedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yakimovdenis.multimedia.models.DBEntity;
import org.yakimovdenis.multimedia.models.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommandsServiceImpl implements CommandsService {

    @Autowired
    private DBEntitysService dbEntitysService;

    @Autowired
    private GenresService genresService;

    @Override
    public void executeCommand(String... strings) {
        if (strings[0] != "manager") {
            System.out.println("Command must start with \"manager\" clause.");
        }

        String result = null;
        switch (strings[1]) {
            case "print": {
                System.out.println(print(Arrays.copyOfRange(strings, 2, strings.length)));
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
        switch (strings[0]) {
            case "games": {
                return serialization(getEntitiesAction(MediaType.GAME.ordinal(), strings));
            }
            case "movies": {
                return serialization(getEntitiesAction(MediaType.MOVIE.ordinal(), strings));
            }
            case "books": {
                return serialization(getEntitiesAction(MediaType.BOOK.ordinal(), strings));
            }
        }
        return "Wrong search command";
    }

    private List<DBEntity> getEntitiesAction(Integer type, String... strings) {
        List<DBEntity> result = null;
        if (strings.length < 2) {
            result = dbEntitysService.getAllWithType(type);
        } else {
            result = new ArrayList<>();
            result.add(dbEntitysService.getEntityByName(strings[1]));
        }
        return result;
    }

    private String serialization(List<DBEntity> entities){
        StringBuilder builder = new StringBuilder("SEARCH RESULT:");
        for (DBEntity entity:entities){
            builder.append('\n').append(entity.toString());
        }
        return builder.toString();
    }

}
