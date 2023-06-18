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
        portaNord.setPickupable(false);
        portaNord.setPushable(false);
        portaNord.setPush(false);
        portaNord.setOpen(true);
        //entryway.getObjects().add(portaNord);
        Object portaSud = new Object(2,"porta sud", "Sembrerebbe la porta di ingresso, chissà se si può aprire");
        portaSud.setOpen(false);
        portaSud.setOpenable(false);
        portaSud.setPickupable(false);
        portaSud.setPushable(false);
        portaSud.setPush(false);
        //entryway.getObjects().add(portaSud);
        
        // ripostiglio
        Object Closetdor = new Object (3, "Porta", "Una porta chissa se si può aprire?");
        Closetdor.setOpen(true);
        Closetdor.setPickupable(false);
        Closetdor.setPushable(false);
        Closetdor.setOpenable(false);
        Closetdor.setPush(false);
        //Closet.getObjects().add(Closetdor);
        ObjectContainer Generator = new ObjectContainer(4, "generatore","Un generatore molto silenzioso, chissà se funziona");
        Generator.setLook("Guardando meglio ti accorgi che manca il carburante");
        Generator.setPickupable(false);
        Generator.setPushable(false);
        Generator.setPush(false);
        //closet.getObjectsContainer().add(Generator);
        Object Reservoir = new Object(5,"serbatoio","contenitore per la benzina");
        Reservoir.setFillable(true);
        Reservoir.setPushable(false);
        Reservoir.setPush(true);
        Reservoir.setPickupable(false);
        Generator.add(Reservoir);
        ObjectContainer Rack = new ObjectContainer(6, "scaffale", "uno scaffale dove al suo interno sembra ci siano degli oggetti");
        Rack.setPushable(false);
        Rack.setPush(false);
        Rack.setPickupable(false);
        //closet.getObjectContainer().add(Rack);
        Object Rope = new Object(7,"corda","una corda molto resistente");
        Rope.setPushable(false);
        Rope.setPush(false);
        Rope.setOpenable(false);
        Rope.setOpen(false);
        Object Scotch = new Object(8,"nasto adesivo", "un ssemplice nastro adesivo");
        Scotch.setPushable(false);
        Scotch.setPush(false);
        Scotch.setOpenable(false);
        Scotch.setOpen(false);
        Object Fuel = new Object(9,"tanica di benzina", "una tanica di benzina piena");
        Fuel.setPushable(false);
        Fuel.setPush(false);
        Fuel.setOpenable(false);
        Fuel.setOpen(false);
        Object Hammer = new Object(10, "martello", "un martello molto pratico per ottime martellate");
        Hammer.setPushable(false);
        Hammer.setPush(false);
        Hammer.setOpenable(false);
        Hammer.setOpen(false);
        Object Nails = new Object(11, "chiodi","Dei chiodi molto utili se si ha un martello");
        Nails.setPushable(false);
        Nails.setPush(false);
        Nails.setOpenable(false);
        Nails.setOpen(false);
        Object Bucket = new Object(12,"secchio","un secchio utile se c'è dell'acqua da prendere");
        Bucket.setPushable(false);
        Bucket.setPush(false);
        Bucket.setOpenable(false);
        Bucket.setOpen(false);
        Object Crowbar = new Object(13,"piede di porco","un piede di porco utile per qualsiasi idea vi passi per la testa");
        Crowbar.setPushable(false);
        Crowbar.setPush(false);
        Crowbar.setOpenable(false);
        Crowbar.setOpenable(false);
        Crowbar.setOpen(false);
        Rack.add(Rope);
        Rack.add(Scotch);
        Rack.add(Fuel);
        Rack.add(Hammer);
        Rack.add(Nails);
        Rack.add(Bucket);
        Rack.add(Crowbar);
        //TODO: da verificare se inserire i singoli oggetti contenuti nell'oggetto contenitore deve esere inseriti singolarmente nella stanza
       
        // sala da pranzo
        Object DiningRoomDoor = new Object(14,"porta sala da pranzo","una porta chissà se si può aprire");
        DiningRoomDoor.setPushable(false);
        DiningRoomDoor.setPush(false);
        DiningRoomDoor.setPickupable(false);
        // DiningRoom.getObjects().add(DiningRoomDoor);
        // TODO: il cibo all'interno dei piatti è avvelenato e il personaggio perde una vita
        Object Dishes = new Object(15, "piatti","dei piatti con ancora del cibo al loro interno, chissà se è buono");
        Dishes.setPickupable(true);
        //DiningRoom.getObjects().add(Dishes);
        Object Silverware = new Object(16,"posate","Utili per afferrare cosa c'è nel piatto");
        Silverware.setPushable(false);
        Silverware.setPush(false);
        Silverware.
        //DinningRoom.getObjects().add(Silverware);
        Object Glasses = new Object(17,"bicchieri","Utili per bere qualsiasi fluido ");
        //DinningRoom.getObjects().add(Glasses);
        Object Napkins = new Object(18,"tovaglioli","Utili per pulirsi");
        //DinningRoom.getObjects().add(Napkins);
        Object Candles = new Object(19,"candele","Ottime per illuminare e scaldare un ambiente");
        //DinningRoom.getObjects().add(Candles);
        ObjectContainer Butler = new ObjectContainer(20,"magiordomo","si chiama Ambrogio ed è il magiordomo di questo castello, al collo ha appesa una chiave e sembra essere non intenzionato a dartela");
        //DinningRoom.getObjects().add(Butler);
        //TODO: definire le azioni che si possono fare con il maggiordomo
        Object key1 = new Object(21,"chiave","una chiave che probabilmente può aprire una serratura");        
        key1.setPickupable(true);
        Butler.add(key1);
        
        //ogetti biblioteca
        
        Object Card = new Object(22,"bigliettino","");
        Card.setPickupable(true);
        //TODO: inserire gli indovinelli che ti conducono alla chiave
        //Library.getObjects().add(Card);
        //TODO: se c'è tempo ampliare i libri dello scaffale e aggiungere nome del libro
        ObjectContainer Bookcase = new Object(23,"scaffale di libri","nome libro");
         //Library.getObjects().add(Bookcase);
        Object Book1 = new Object(24,"libro","questo libro sembra essere piu pulito rispetto a gli altri"); 
        Book1.setPickupable(true);
        Bookcase.add(Book1);
        ObjectContainer Secretbox = new ObjectContainer(25,"scompartimento segreto","al suo interno c'è una chiave insieme ad odere di qualcosa andato a male,"
         + " sembra che qualcuno ci abbia lasciato il pranzo");
        Secretbox.setOpen(false);
        //Library.getObjects().add(Secretbox);
        Object key2 = new Object(26,"chiave","una chiave utile per aprire una serratura, chissà quale");
        key2.setPickupable(true);
        Secretbox.add(key2);
       
        //ogetti soggiorno
        
        Object Torch = new Object(27,"fiaccola","una fiaccolaa spenta, in presenza di fuoco potrebbe tornarti utile per illuminare il cammino"
        + "e non calpestare qualcosa di spiacevole");
        Torch.setPickupable(true);
        Torch.setPushable(true);
        //Livingroom.getObjects().add(Torch);
        Object Chimney = new Object(28,"camino","un bel caminetto con del fuoco accesso, she hai con te delle salsicce puoi fare un ottimo spuntino");
        //Livingroom.getObjects().add(Chimney);
        Object Mail = new Object(29,"lettera","");
        Mail.setPickupable(true);
        //TODO: inserire la descrizione della lettera
        //Livingroom.getObjects().add(Mail);
        Object key3 = new Object(30,"chiave","una chiave utile per aprire una serratura, chissà quale");
        key3.setPickupable(true);
        //Livingroom.getObjects().add(key3);
        
        
        //oggetti dispensa
        
        Object Foodstocks = new Object(33,"scorte di viveri","qui c'è del cibo per sfamare l'africa");
        //Foodstorage.getObjects().add(Foodstocks);
        Object Winecellar = new Object(34,"cantina di vini","una preziosa scorta di vini profumati ed inebrianti ottimi per le migliori feste da palazzo");
        //Foodstorage.getObjects().add(Winecellar);
        ObjectContainer Winebottle = new ObjectContainer(35,"bottiglia di vino","sembra che al suo intenro ci sia una chiave");
        Winebottle.setOpen(false);
        //Foodstorage.getObjects().add(Winebottle);
        //TODO: inserire le zioni che puo effettuare con la bottiglia
        Object key4 = new Object(35,"chiave","una chiave utile per aprire una serratura, chissà quale");
        key4.setPickupable(true);
        Winebottle.add(key4);
       
        //oggetti stanza della servitu
        Object Wardrobe = new Object(36,"guardaroba","un semplice armadio dove al suo interno contiene dei vestiti ");
        //Servantsroom.getObjects().add(Wardrobe);
        Object NightTable = new Object(37,"comodino","un semplice comodino usato dalla servitu per deporre gli ogetti, ma sembra sia vuoto");
        //Servantsroom.getObjects().add(NightTable);
        Object Diary = new Object(38,"diario","un diario molto importante per la persona che lo custodiva");
        //Servantsroom.getObjects().add(Diary);
        
        //ogetti armeria
        
        Object Rifle = new Object(39,"fucile","un ottima arma per incutere timore a chi hai di fronte, inutile se mancano le munizioni");
        //Armoryroom.getObjects().add(Rifle);
        Object Glock17 = new Object(40,"pistola","un arma abbastanza pratica per eliminare i tuoi nemici, ma a senza munizione puoi usarla come martello");
        //Armoryroom.getObjects().add(Glock17);
        Object Spear = new Object(41,"lancia","un arma usata nell'era glaciale per abbattere i mammut, ottima per il suo periodo storico");
        //Armoryroom.getObjects().add(Spear);
        Object Sword = new Object(42,"spada","ottima nelle grandi battaglie, questa sembra sia salda al muro");
        //Armoryroom.getObjects().add(Sword);
        Object key5 = new Object(43,"chiave","una chiave utile per aprire una serratura, chissà quale"); 
        //Armoryroom.getObjects().add(key5);
        Object Guardian = new Object(44,"guardiano","Lui è Robert il guardiano di questo castello, a lui non sfugge nulla, neanche quando dorme");
        //Armoryroom.getObjects().add(Guardian);
        Object GrapplingHook = new Object(45,"rampino","un oggetto che se lanciato si aggrappa ovunque, ma inutile senza una corda");
        //TODO: inserire l'azione che unisce gli oggetti e modificare la descrizione del rampino
        //Armoryroom.getObjects().add(GrapplingHook);
        
        // oggetti bagno
        
        Object Ghost = new Object(46,"fantasma","un anima in pena che sembra sia molto affezzionata a questa stanza, chissa cosa c'è che richiama la sua attenzione");
        //Bathroom.getObjects().add.(Ghost);
        Object key6 = new Object(47,"chiave","una chiave utile per aprire una serratura, chissà quale"); 
        //Bathroom.getObjects().add.(key6);
        
        //scale che portano al secondo piano
        
        Object Gate = new Object(48,"cancello","questo cancello ti blocca la strada, trova la chiave che lo apre o trova un altro modo per oltrepassarlo");
        //Stairs.getObjects().add(Gate);
        
        //corridioio secondo piano
        
        Object Ares = new Object(49,"scultura di ares","un scultura molto bella che raffigura ares il dio della guerra");
        
        //studio secondo piano
        
        Object Mail2 = new Object(50,"lettera","Caro james, se stai leggendo questa lettera vuole dire che sono fuggito, mi avevano quasi preso quei maledetti cosacchi,"
                + " menumale che mio nonno fece costruire un passaggio segreto per fuggire dal castello dove sgattaiolava da sua moglie per andare a trovare le sue giovani amiche del bordello,"
                + "inoltre questo passaggio portava in cima ad una torre dove nascondeva la sua collezione di vini, il passaggio è raffigurato in un quadro, trova l'ingresso e portami una di quelle bottiglie,"
                + "ti aspetto fuori dalle mura del castello, mi raccomando james non dimenticarti le bottiglie!");  
        //StudyRoom.getObjects().add(Mail2);
        Object Square = new Object(51,"quadro","il quadro raffigura la statua di ares il dio della guerra con un braccio abbassato");
        //StudyRoom.getObjects().add(Square);
        
        //bagno secondo piano
        
        Object Square2 = new Object(52,"quadro","il quadro raffigura una persona che si arrampica sul balcone dal cortile del castello, usando un rampino, un tizio molto abile");
        
        // oggetti camera padronaria secondo piano
        // MasterBadroom.getObjects().add.();
        //TODO: inserire oggetti camera padronaria
        
        //oggetti torre 
        Object MisterX = new Object(53,"MisterX","si presenta con una benda all'occhio, un barbone non curata e un fare minaccioso, il classico tipo losco da non farti mai nemico"); 
        //Tower.getObjects().add(MisterX);
        Object Stecy = new Object(54,"Stecy","una bella ragazza con dei lineamenti del viso armoniosi e proporzionati con occhi grandi e luminosi, la classica ragazza acqua e sapone");
        //Tower.getObjects().add(Stecy);


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
