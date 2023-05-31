/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintStream;
import java.util.Iterator;

/**
 * @author pierpaolo
 */
public class FireHouseGame extends GameDescription {

    @Override
    public void init() throws Exception {
        //Commands
        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD"});
        getCommands().add(nord);
        Command iventory = new Command(CommandType.INVENTORY, "inventario");
        iventory.setAlias(new String[]{"inv"});
        getCommands().add(iventory);
        Command sud = new Command(CommandType.SOUTH, "sud");
        sud.setAlias(new String[]{"s", "S", "Sud", "SUD"});
        getCommands().add(sud);
        Command est = new Command(CommandType.EAST, "est");
        est.setAlias(new String[]{"e", "E", "Est", "EST"});
        getCommands().add(est);
        Command ovest = new Command(CommandType.WEST, "ovest");
        ovest.setAlias(new String[]{"o", "O", "Ovest", "OVEST"});
        getCommands().add(ovest);
        Command end = new Command(CommandType.END, "end");
        end.setAlias(new String[]{"end", "fine", "esci", "muori", "ammazzati", "ucciditi", "suicidati", "exit"});
        getCommands().add(end);
        Command look = new Command(CommandType.LOOK_AT, "osserva");
        look.setAlias(new String[]{"guarda", "vedi", "trova", "cerca", "descrivi"});
        getCommands().add(look);
        Command pickup = new Command(CommandType.PICK_UP, "raccogli");
        pickup.setAlias(new String[]{"prendi"});
        getCommands().add(pickup);
        Command open = new Command(CommandType.OPEN, "apri");
        open.setAlias(new String[]{});
        getCommands().add(open);
        Command push = new Command(CommandType.PUSH, "premi");
        push.setAlias(new String[]{"spingi", "attiva"});
        getCommands().add(push);
        //Rooms
        
        //secondo piano
        Room badroomGirl = new Room(0, "Camera da letto della figlia", "Sei nella camera da letto di una bambina.\n Non ci sono altri ingressi o uscite, vedi un letto con il comodino,"
                + " un armadio la cui anta è aperta: si intravedono abiti da bambina. Infine c'è un mobile con uno specchio.");
        Room badroomBoy = new Room(1, "Camera da letto del figlio", "Sei nella camera da letto di un bambino.\n Non ci sono altri ingressi o uscite, c'è un armadio, un letto, un comodino e una scrivania");
        badroomBoy.setLook("Osservando meglio la stanza la tua attenzione cade sulla scrivania: noti che ci sono delle foto.");
        
        //ground floor
        Room stair = new Room(1, "Scale", "e' una stanza completamente spoglia: non ci sono arrede di alcun tipo. L'unica cosa che contiene sono le sclae che portano al piano superiore.");
        stair.setVisible(false);
        Room hall2 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e nord il corridoio prosegue. A sud trovi un cancello; mentre a ovest una porta aperta.");
        Room hall3 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        
        //TODO: Ricordarsi di inserire questa descrizione quando entra la prima volta nel primo corridoio: Aprendo porta ti trovi sotto a un porticato che percorre tutto il perimetro del cortile. Da dove ti trovi riesci a vedere che dal sotto il porticato si trovano diversi ingressi a varie stanze. 
        Room hall4 = new Room(4, "Corridoio", "Sei nel corridoio. di per se non c'e' niente di particolare. Riesci a vedere il giardino. A nord, infatti, trovi il suo entrata, mentre a sud hai la prota per"
                + " andare nell'ingresso. A est e ovest il corridoio prosegue.");        
        Room hall5 = new Room(5, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        
        Room hall6 = new Room(6, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall7 = new Room(7, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall8 = new Room(8, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall9 = new Room(9, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall10 = new Room(10, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall11 = new Room(11, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall12 = new Room(12, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall13 = new Room(13, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall14 = new Room(14, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall15 = new Room(15, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall16 = new Room(16, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall17 = new Room(17, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall18 = new Room(18, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        Room hall19 = new Room(19, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e ovest il corridoio prosegue.");
        
        Room entryway = new Room(19, "Ingresso", "Sei nell'ingresso. Guardandoti intorno non noti niente di particolare. È un ingresso come tanti: c’è un tappeto con sopra un tavolino, alle pareti ci sono "
                + "dei quadri e il tipico lampadario dell’epoca. A nord c’è una porta mentre sulla parete sud c'e' la porta dell'ingresso principale e ci sono un paio di finestre: entrambe però sono sbarrate. "
                + "(Ti sarebbe piaciuto fuggire così in fretta?!!!).");
        Room yard = new Room();
        Room closet = new Room();
        Room bathroom1 = new Room();
        
        
        Room hall = new Room(0, "Corridoio", "Sei appena tornato a casa e non sai cosa fare.\nTi ricordi che non hai ancora aperto quel fantastico regalo di tua zia Lina.\n"
                + " Sarà il caso di cercarlo e di giocarci!");
        hall.setLook("Sei nel corridoio, a nord vedi il bagno, a sud il soggiorno e ad ovest la tua cameretta, forse il gioco sarà lì?");
        Room livingRoom = new Room(1, "Soggiorno", "Ti trovi nel soggiorno.\nCi sono quei mobili marrone scuro che hai sempre odiato e delle orribili sedie.");
        livingRoom.setLook("Non c'è nulla di interessante qui.");
        Room kitchen = new Room(2, "Cucina", "Ti trovi nella solita cucina.\nMobili bianchi, maniglie azzurre, quello strano lampadario che adoravi tanto quando eri piccolo.\n"
                + "C'è un tavolo con un bel portafrutta e una finestra.");
        kitchen.setLook("La solita cucina, ma noti una chiave vicino al portafrutta.");
        Room bathroom = new Room(3, "Bagno", "Sei nel bagno.\nQuanto tempo passato qui dentro...meglio non pensarci...");
        bathroom.setLook("Vedo delle batterie sul mobile alla destra del lavandino.");
        Room yourRoom = new Room(4, "La tua cameratta", "Finalmente la tua cameretta!\nQuesto luogo ti è così famigliare...ma non ricordi dove hai messo il nuovo regalo di zia Lina.");
        yourRoom.setLook("C'è un armadio bianco, di solito ci conservi i tuoi giochi.");
        
        //map
        entryway.setNorth(hall4);
        hall2.setEast(hall3);
        hall2.setWest(bathroom1);
        hall3.setEast(hall4);
        hall3.setWest(hall2);
        hall4.setNorth(yard);
        hall4.setSouth(entryway);
        hall4.setEast(hall5);
        hall4.setWest(hall3);
        hall5.setEast(hall6);
        hall5.setWest(hall4);
        hall3.setEast(hall4);
        hall3.setWest(hall2);
        
        
        
        kitchen.setEast(livingRoom);
        livingRoom.setNorth(hall);
        livingRoom.setWest(kitchen);
        hall.setSouth(livingRoom);
        hall.setWest(yourRoom);
        hall.setNorth(bathroom);
        bathroom.setSouth(hall);
        yourRoom.setEast(hall);
        getRooms().add(kitchen);
        getRooms().add(livingRoom);
        getRooms().add(hall);
        getRooms().add(bathroom);
        getRooms().add(yourRoom);
        
         //obejcts primo piano
        
        // ingresso
        Object portaNord = new Object(1, "porta nord", "Una porta chissa se si può aprire?");
        //entryway.getObjects().add(portaNord);
        portaNord.setOpen(true);
        Object portaSud = new Object(2,"porta sud", "Sembrerebbe la porta di ingresso, chissà se si può aprire");
        //entryway.getObjects().add(portaSud);
        portaSud.setOpen(false);
        
        // ripostiglio
        Object portaRipostiglioCorridoio = new Object (3, "Porta", "Una porta chissa se si può aprire?");
        //closet.getObjects().add(portaRipostiglioCorridioio);
        portaRipostiglioCorridoio.setOpen(true);
        ObjectContainer generator = new ObjectContainer(4, "generatore","Un generatore molto silenzioso, chissà se funziona");
        //closet.getObjectsContainer().add(generator);
        generator.setLook("Guardando meglio ti accorgi che manca il carburante");
        generator.setOpenable(true);
        Object reservoir = new Object(5,"serbatoio","contenitore per la benzina");
        reservoir.setFillable(true);
        generator.add(reservoir);
        ObjectContainer rack = new ObjectContainer(6, "scaffale", "uno scaffale dove al suo interno sembra ci siano degli oggetti");
        //closet.getObjectContainer().add(rack);
        Object rope = new Object(7,"corda","una corda molto resistente");
        rope.setPickupable(true);
        Object Scotch = new Object(8,"nasto adesivo", "un ssemplice nastro adesivo");
        Scotch.setPickupable(true);
        Object fuel = new Object(9,"tanica di benzina", "una tanica di benzina piena");
        fuel.setPickupable(true);
        Object hammer = new Object(10, "martello", "un martello molto pratico per ottime martellate");
        hammer.setPickupable(true);
        Object nails = new Object(11, "chiodi","Dei chiodi molto utili se si ha un martello");
        nails.setPickupable(true);
        Object bucket = new Object(12,"secchio","un secchio utile se c'è dell'acqua da prendere");
        bucket.setPickupable(true);
        Object crowbar = new Object(13,"piede di porco","un piede di porco utile per qualsiasi idea vi passi per la testa");
        crowbar.setPickupable(true);
        rack.add(rope);
        rack.add(Scotch);
        rack.add(fuel);
        rack.add(hammer);
        rack.add(nails);
        rack.add(bucket);
        rack.add(crowbar);
        //TODO: da verificare se inserire i singoli oggetti contenuti nell'oggetto contenitore deve esere inseriti singolarmente nella stanza
        // sala da pranzo
        Object DiningRoomDoor = new Object(14,"porta sala da pranzo","una porta chissà se si può aprire");
        DiningRoomDoor.setOpen(true);
        //DiningRoom.getObjects().add(DiningRoomDoor);
        
       
        //obejcts
        Object battery = new Object(1, "batteria", "Un pacco di batterie, chissà se sono cariche.");
        battery.setAlias(new String[]{"batterie", "pile", "pila"});
        bathroom.getObjects().add(battery);
        ObjectContainer wardrobe = new ObjectContainer(2, "armadio", "Un semplice armadio.");
        wardrobe.setAlias(new String[]{"guardaroba", "vestiario"});
        wardrobe.setOpenable(true);
        wardrobe.setPickupable(false);
        wardrobe.setOpen(false);
        yourRoom.getObjects().add(wardrobe);
        Object toy = new Object(3, "giocattolo", "Il gioco che ti ha regalato zia Lina.");
        toy.setAlias(new String[]{"gioco", "robot"});
        toy.setPushable(true);
        toy.setPush(false);
        wardrobe.add(toy);
        Object kkey = new Object(4, "chiave", "Usa semplice chiave come tante altre.");
        toy.setAlias(new String[]{"key"});
        toy.setPushable(false);
        toy.setPush(false);
        kitchen.getObjects().add(kkey);
        //set starting room
        setCurrentRoom(hall);
    }

    @Override
    public void nextMove(ParserOutput p, PrintStream out) {
        if (p.getCommand() == null) {
            out.println("Non ho capito cosa devo fare! Prova con un altro comando.");
        } else {
            //move
            boolean noroom = false;
            boolean move = false;
            if (p.getCommand().getType() == CommandType.NORD) {
                if (getCurrentRoom().getNorth() != null) {
                    setCurrentRoom(getCurrentRoom().getNorth());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                if (getCurrentRoom().getSouth() != null) {
                    setCurrentRoom(getCurrentRoom().getSouth());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.EAST) {
                if (getCurrentRoom().getEast() != null) {
                    setCurrentRoom(getCurrentRoom().getEast());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.WEST) {
                if (getCurrentRoom().getWest() != null) {
                    setCurrentRoom(getCurrentRoom().getWest());
                    move = true;
                } else {
                    noroom = true;
                }
            } else if (p.getCommand().getType() == CommandType.INVENTORY) {
                out.println("Nel tuo inventario ci sono:");
                for (Object o : getInventory()) {
                    out.println(o.getName() + ": " + o.getDescription());
                }
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {
                if (getCurrentRoom().getLook() != null) {
                    out.println(getCurrentRoom().getLook());
                } else {
                    out.println("Non c'è niente di interessante qui.");
                }
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {
                if (p.getObject() != null) {
                    if (p.getObject().isPickupable()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        out.println("Hai raccolto: " + p.getObject().getDescription());
                    } else {
                        out.println("Non puoi raccogliere questo oggetto.");
                    }
                } else {
                    out.println("Non c'è niente da raccogliere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.OPEN) {
                /*ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                * Potrebbe non esssere la soluzione ottimale.
                 */
                if (p.getObject() == null && p.getInvObject() == null) {
                    out.println("Non c'è niente da aprire qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                            if (p.getObject() instanceof ObjectContainer) {
                                out.println("Hai aperto: " + p.getObject().getName());
                                ObjectContainer c = (ObjectContainer) p.getObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getName() + " contiene:");
                                    Iterator<Object> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        getCurrentRoom().getObjects().add(next);
                                        out.print(" " + next.getName());
                                        it.remove();
                                    }
                                    out.println();
                                }
                                p.getObject().setOpen(true);
                            } else {
                                out.println("Hai aperto: " + p.getObject().getName());
                                p.getObject().setOpen(true);
                            }
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                            if (p.getInvObject() instanceof ObjectContainer) {
                                ObjectContainer c = (ObjectContainer) p.getInvObject();
                                if (!c.getList().isEmpty()) {
                                    out.print(c.getName() + " contiene:");
                                    Iterator<Object> it = c.getList().iterator();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        getInventory().add(next);
                                        out.print(" " + next.getName());
                                        it.remove();
                                    }
                                    out.println();
                                }
                                p.getInvObject().setOpen(true);
                            } else {
                                p.getInvObject().setOpen(true);
                            }
                            out.println("Hai aperto nel tuo inventario: " + p.getInvObject().getName());
                        } else {
                            out.println("Non puoi aprire questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.PUSH) {
                //ricerca oggetti pushabili
                if (p.getObject() != null && p.getObject().isPushable()) {
                    out.println("Hai premuto: " + p.getObject().getName());
                    if (p.getObject().getId() == 3) {
                        end(out);
                    }
                } else if (p.getInvObject() != null && p.getInvObject().isPushable()) {
                    out.println("Hai premuto: " + p.getInvObject().getName());
                    if (p.getInvObject().getId() == 3) {
                        end(out);
                    }
                } else {
                    out.println("Non ci sono oggetti che puoi premere qui.");
                }
            }
            if (noroom) {
                out.println("Da quella parte non si può andare c'è un muro!\nNon hai ancora acquisito i poteri per oltrepassare i muri...");
            } else if (move) {
                out.println(getCurrentRoom().getName());
                out.println("================================================");
                out.println(getCurrentRoom().getDescription());
            }
        }
    }

    private void end(PrintStream out) {
        out.println("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
        System.exit(0);
    }
}
