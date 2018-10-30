package com.epam.geometry.service.commandsForSphereCenter;

import com.epam.geometry.entity.CoordinatePlane;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CoordinatePlane, Command> commandMap = new HashMap<>();

    public CommandProvider() {
        commandMap.put(CoordinatePlane.OYZ, new GetXofSphereCenterCommand());
        commandMap.put(CoordinatePlane.XOZ, new GetYofSphereCenterCommand());
        commandMap.put(CoordinatePlane.XYO, new GetZofSphereCenterCommand());

    }

    public Command getCommand(CoordinatePlane commandName){
        return commandMap.get(commandName);
    }
}
