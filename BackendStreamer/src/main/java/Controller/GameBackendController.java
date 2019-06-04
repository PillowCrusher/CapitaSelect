package Controller;

import Service.BattleBroService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/game")
@Produces({MediaType.APPLICATION_JSON})
public class GameBackendController {
    @Resource
    private SessionContext context;
    @Inject
    private BattleBroService battleBroService;
}
