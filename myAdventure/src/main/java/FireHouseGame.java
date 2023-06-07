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
        //ground floor
        Room stair = new Room(1, "Scale", "É una stanza completamente spoglia: non ci sono arredi di alcun tipo. L'unica cosa che contiene sono le scale che portano al piano superiore.");
        stair.setVisible(false);
        Room hall2 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A ovest e a nord il corridoio prosegue. A sud trovi un cancello; mentre a est una porta aperta.");
        Room hall3 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue.");
        // TODO: Ricordarsi di inserire questa descrizione quando entra la prima volta nel primo corridoio: Aprendo porta ti trovi sotto a un porticato che percorre tutto il perimetro del cortile. Da dove ti trovi riesci a vedere che dal sotto il porticato si trovano diversi ingressi a varie stanze. 
        Room hall4 = new Room(4, "Corridoio", "Sei nel corridoio. di per se non c'e' niente di particolare. Riesci a vedere il giardino. A nord, infatti, trovi il suo entrata, mentre a sud hai la prota per"
                + " andare nell'ingresso. A est e ovest il corridoio prosegue.");        
        Room hall5 = new Room(5, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e a ovest il corridoio prosegue.");
        Room hall6 = new Room(6, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord, sud ed est il corridoio prosegue.");
        Room hall7 = new Room(7, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A nord e a sud il corridoio prosegue. A ovest c'è l'ingresso di una stanza.");
        Room hall8 = new Room(8, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A est c'è l'ingresso per il giardino.");
        Room hall9 = new Room(9, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue.");
        Room hall10 = new Room(10, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A ovest vi è l'ingresso di una stanzax.");
        Room hall11 = new Room(11, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A sud e a est il corridoio prosegue.");
        Room hall12 = new Room(12, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue.");
        Room hall13 = new Room(13, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue. A nord come a sud c'è un ingresso.");
        Room hall14 = new Room(14, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e a ovest il corridoio prosegue. A nord vi è l'ingresso di una stanza.");
        Room hall15 = new Room(15, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A ovest e a sud il corridoio prosegue.");
        Room hall16 = new Room(16, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e sud il corridoio prosegue.");
        Room hall17 = new Room(17, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A est c'è lingresso di una stanza, mentre a ovest l'ingresso al cortile");
        Room hall18 = new Room(18, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e ovest il corridoio prosegue.");
        Room hall19 = new Room(30, "Corridoio", "Sei nel corridoio. A nord il corridoio prosegue. A sud e ovest vedi una porta.");
        Room entryway = new Room(19, "Ingresso", "Sei nell'ingresso. Guardandoti intorno non noti niente di particolare. È un ingresso come tanti: c’è un tappeto con sopra un tavolino, alle pareti ci sono "
                + "dei quadri e il tipico lampadario dell’epoca. A nord c'è una porta mentre sulla parete sud c'è la porta dell'ingresso principale e ci sono un paio di finestre: entrambe però sono sbarrate. "
                + "(Ti sarebbe piaciuto fuggire così in fretta?!!!).");
        // TODO: Capire se sono state apportate modifiche al ripostiglio rispetto alla descrizione su teams e trovare una descrizione per quando la stanza è illuminata
        Room closet = new Room(20, "Ripostiglio", "Entrando non riesci a distinguere niente: è troppo buio per vederci qualcosa.");
        closet.setVisible(false);
        Room library = new Room(21, "Biblioteca", "Entrando ti trovi difronte ad un tavolo. Tutto intorno ci sono scaffali. A est c'è la porta da cui sei entrato alla cui destra c’è un mobile con sopra un grande"
                + " libro: “Registro dei libri”.");
        //TODO: Capire come cambiare la descrizione una volta che si è acceso il generatore
        library.setLook("Ogni scaffale ha 5 livelli. Non tutti gli scaffali sono pieni e sembra che qualcuno abbia preso dei libri. Noti infatti che ci sono degli spazi vuoti. infine, noti che sul tavolo c'è un"
                + " bigliettino con su scritto qualcosa.");
        library.setVisible(false);
        Room livingroom = new Room(22, "Soggiorno", "Entrando ti trovi davanti un grande camino acceso ai cui lati ci sono due poltrone. Intravedi anche una scrivania. (Ah, ovviamente a est c'è la porta da cui sei entrato)");
        livingroom.setLook("Osservando meglio sulla scrivania si intravedono dei fogli. Mentre appese alla kappa del camino noti appese delle fiaccole spente.");
        Room diningroom = new Room(23, "Sala da pranzo", "Sei in un enorme sala da pranzo. C’è un tavolo tutto imbandito con tutto il necessario. Ad un angolo del tavolo noti un uomo, forse il maggiordomo della"
                + " villa. A nord intravedi un ingresso verso un'altra stanza: forse la cucina. (Ah, ovviamente a est c'è la porta da cui sei entrato)");
        diningroom.setLook("Osservandolo meglio noti che al collo ha appeso una chiave e che soprattutto non ha una faccia molto amichevole.");
        diningroom.setVisible(false); //TODO: da decidere
        Room kitchen = new Room(24, "Cucina", "Niente di particolare. Una cucina come tante: credenze, forno, frigorifero e cassetti ci sono tutti. Sulla parete sud è presente un ingresso probabilmente verso"
                + "la sala da pranzo, mentre sulla parete est c'è una porta che forse conduce alla dispensa.");
        kitchen.setVisible(false);
        Room lander = new Room(25, "Dispensa", "La dispensa sembra ben rifornita. Oltre a sacchi di farina e vari salumi e formaggi puoi notare una piccola cantina di vini. A ovest dell'ingresso vi "
                + "è una porta che conduce in un'altra stanza, mentre a sud vi è la porta che conduce al corridoio.");
        lander.setLook("Osservando la cantina noti una bottiglia di vino al cui interno brilla una chiave.");
        lander.setVisible(false);
        //TODO: rivedere la stanza della servitù
        Room armory = new Room(27, "Armeria", "Oltre ad un’immensa collezione di fucili, pistole e lance puoi notare anche una serie di oggetti che non sono propriamente armi: caschi, armature, rampini,"
                + " scarpe, occorrenti per giardinaggio, ecc. Inoltre, vedi anche delle panche. Alle tue spalle, sulla parete nord c'è l'ingresso da cui sei entrato. Ma ad attirare la tua attenzione"
                + "è l'echeggiare di rumore.");
        armory.setLook("Una panca, in particolare, attira la tua attenzione: su di essa c’è un uomo che dorme. Appena lo focalizzi ti balza all’occhio la chiave che gli pende dal collo.");
        armory.setVisible(false);//TODO: decidere bene se si vede (ci sono delle torce accese o candele) o meno nella stanza
        Room bathroom1 = new Room(28, "Bagno", "É un normale bagno. Water, bidet, lavandino e vasca. Niente di particolare, se non fosse che a un angolo della vasca vedi una figura."
                + "É un po' strana: sembra trasparente. Appena ti avvicini noti che riesci a vederci attraverso: si tratta di un fantasma!!!! (Ah, ovviamente a ovest c'è la porta da cui sei entrato.)");
        // TODO: Sistemare il cortile: deve essere diviso in più zone e fatta meglio la mappa. Vanno indicate anche le direzioni.
        Room yard = new Room(29, "Cortile", "Al suo interno vedi alberi, cespugli, fiori e siepi.");
        yard.setLook("Guardando meglio, la prima cosa che ti balza all’occhio è un enorme cilindro che sembra alto circa 3 metri al cui interno c’è una chiave esposta. Ti rendi conto anche che una parte del cortile"
                + " è coperta da un balcone che sembra essere l’affaccio di qualche stanza del primo piano.");
        
        //secondo piano
        Room stairs_2 = new Room(31, "Scale", "Salendo ti ritrovi un’ampia stanza da cui, ben presto, capisci che si tratta di un corridoio che circonda l’intero palazzo.");
        stairs_2.setLook("C'è ben poco arredamento: un tappeto posizionato al centro della stanza sembra percorrere l’intero corridoio, ci sono delle sculture.");
        stairs_2.setVisible(false);
        Room hall2_2 = new Room(32, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finestra."
                + " A ovest e a nord il corridoio prosegue. A sud vai verso le scale.");
        hall2_2.setVisible(false);
        Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale.");
        hall3_2.setVisible(false);
        Room hall4_2 = new Room(34, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finestra."
                + " A ovest e a est il corridoio prosegue. A nord vi è l'ingresso di una stanza.");
        hall4_2.setVisible(false);
        Room hall5_2 = new Room(35, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso. A sud, dove dovrebbe esserci l'ingresso per la torre c’è una scultura. "
                + " A ovest e a est il corridoio prosegue.");
        hall5_2.setLook("La scultura raffigura un dio greco in una posa particolare: è in piedi con il braccio sinistro che regge uno scudo, mentre il braccio desto mantiene una spada sollevata.");
        hall5_2.setVisible(false);
        Room hall6_2 = new Room(36, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a est il corridoio prosegue. ");
        hall6_2.setVisible(false);
        Room hall7_2 = new Room(37, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. ");
        hall7_2.setVisible(false); 
        Room hall8_2 = new Room(38, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finesta s, rigorosamente sbarrata."
                + " A nord e a sud il corridoio prosegue. ");
        hall8_2.setVisible(false);
        Room hall9_2 = new Room(39, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A est entri in una stanza");
        hall9_2.setVisible(false);
         
        Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale");
        hall3_2.setVisible(false);
         Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale");
        hall3_2.setVisible(false);
         Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale");
        hall3_2.setVisible(false);
         Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale");
        hall3_2.setVisible(false);
         Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale");
        hall3_2.setVisible(false);
         Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale");
        hall3_2.setVisible(false);
        
        Room anteroom = new Room(51, "Anticamera", "La prima cosa che ti colpisce entrando è l’enorme finestrone aperto che affaccia sul cortile. "
                + "Ad entrambi i lati della stanza ci sono delle porte, una chiusa e l’altra aperta. Al centro ci sono dei divani posti intorno ad un tavolino da caffè su cui ci sono delle riviste di abiti da sposa. ");
        anteroom.setVisible(false);
        Room bedroomBoy = new Room(55, "Camera da letto del figlio", "Sei nella camera da letto di un bambino.\n Non ci sono altri ingressi a parte quello cui sei entrato, c'è un armadio, un letto, un comodino e una scrivania.");
        bedroomBoy.setLook("Osservando meglio la stanza la tua attenzione cade sulla scrivania: noti che ci sono delle foto.");
        bedroomBoy.setVisible(false);
        Room bedroomGirl = new Room(52, "Camera da letto della figlia", "Sei nella camera da letto di una bambina.\n Non ci sono altri ingressi se non quello da cui sei entrato, vedi un letto con il comodino,"
                + " un armadio la cui anta è aperta: si intravedono abiti da bambina. Infine c'è un mobile con uno specchio.");
        bedroomGirl.setVisible(false);
        Room studio = new Room(56, "Studio", "");
        Room tower = new Room(58, "TOrre", "Attraversato l'ingresso dietro la statua ti trovi in uno stretto corridoio. Al termine una luce ti attende. Man mano che ti avvicini senti la rabbia che sale, ma allo stesso"
                + " tempo paura nel temere per quello che può aver fatto quel pazzo alla tua amata Stecy. É li che è tenuta nascosta? Come stara? Arrivato alla fine del corridoio ti trovi difronte colui che ha "
                + "organizzato tutto: Mister X. Il luogo in cui si nasconde, la torre, è una specie di ripostiglio. sembra che ci siano dei mobili, ma questi sono tutti coperti da teli bianchi. L'unico oggetto scoperto,"
                + " una sedia, è quella su cui è legata Stecy. Mister X, invece, è appoggiato a quella che sembra una scrivania.");
        Room balconyAnteroom = new Room(61, "Balcone anticamera", "Affacciandoti dal balcone riesci a vdere l'intero cortile e il balcone difronte. li però la finestra sembra chiusa."
                + "A sud trovi l'ingresso alla stanza.");
        balconyAnteroom.setVisible(false);

        /*TODO: Capire come gestire il fatto delle stanze illuminate e buie
        una possibile idea è ampliare il costruttore delle stane aggiungendo un
        ulteriore variabile stringa che contiene la descrizione della stanza quando 
        non è illuminata.*/
        
        //map
        entryway.setNorth(hall4);
        hall2.setEast(bathroom1);
        hall2.setWest(hall3);
        hall2.setNorth(hall18);
        hall2.setSouth(stair); //TODO: ho dei dubbi sul fatto che debba stare
        hall3.setEast(hall2);
        hall3.setWest(hall4);
        hall4.setNorth(yard);
        hall4.setSouth(entryway);
        hall4.setEast(hall3);
        hall4.setWest(hall5);
        hall5.setEast(hall4);
        hall5.setWest(hall6);
        hall6.setSouth(hall19);
        hall6.setEast(hall15);
        hall6.setNorth(hall7);
        hall7.setNorth(hall8);
        hall7.setSouth(hall6);
        hall7.setWest(livingroom);
        hall8.setNorth(hall9);
        hall8.setSouth(hall7);
        hall8.setEast(yard);
        hall9.setNorth(hall10);
        hall9.setSouth(hall8);
        hall10.setNorth(hall11);
        hall10.setSouth(hall9);
        hall10.setWest(diningroom);
        hall11.setSouth(hall10);
        hall11.setEast(hall12);
        hall12.setEast(hall13);
        hall12.setWest(hall11);
        hall13.setNorth(lander);
        hall13.setSouth(yard);
        hall13.setEast(hall14);
        hall13.setWest(hall12);
        hall14.setEast(hall15);
        hall14.setWest(hall13);
        //TODO hall14.setNorth(stanzadellaservitù);
        hall15.setWest(hall14);
        hall15.setSouth(hall16);
        hall16.setNorth(hall15);
        hall16.setSouth(hall17);
        hall17.setNorth(hall16);
        hall17.setSouth(hall18);
        hall17.setWest(yard);
        hall17.setEast(armory);
        hall18.setNorth(hall17);
        hall18.setSouth(hall2);
        hall19.setNorth(hall6);
        hall19.setSouth(closet);
        hall19.setWest(library);
        closet.setNorth(hall19);
        library.setEast(hall19);
        livingroom.setEast(hall7);
        diningroom.setNorth(kitchen);
        diningroom.setEast(hall10);
        kitchen.setSouth(diningroom);
        kitchen.setEast(lander);
        lander.setWest(kitchen);
        lander.setSouth(hall13);
        armory.setWest(hall17);
        bathroom1.setWest(hall2);
        yard.setSouth(hall4);
        yard.setNorth(hall13);
        yard.setWest(hall8);
        yard.setEast(hall17);
        //TODO stanzadellaservitù.setSouth(hall14);
        
        stairs_2.setNorth(hall2_2);
        hall2_2.setNorth(hall20_2);
        hall2_2.setSouth(stairs_2);
        hall2_2.setWest(hall3_2);
        hall3_2.setSouth(stairs_2);
        hall3_2.setWest(hall4_2);
        hall3_2.setEast(hall2_2);
        hall4_2.setEast(hall3_2);
        hall4_2.setWest(hall5_2);
        hall4_2.setNorth(anteroom);
        hall5_2.setWest(hall6_2);
        hall5_2.setEast(hall4_2);
        hall5_2.setSouth(tower);
        hall6_2.setEast(hall5_2);
        hall6_2.setNorth(hall7_2);
        hall7_2.setSouth(hall6_2);
        hall7_2.setNorth(hall8_2);
        hall8_2.setNorth(hall9_2);
        hall8_2.setSouth(hall9_2);
        hall9_2.setNorth(hall10_2);
        hall9_2.setSouth(hall8_2);
        hall9_2.setEast(studio);
        
        
        anteroom.setNorth(balconyAnteroom);
        anteroom.setSouth(hall4_2);
        anteroom.setWest(bedroomBoy);
        anteroom.setEast(bedroomGirl);
        bedroomGirl.setWest(anteroom);
        bedroomBoy.setEast(anteroom);
        
        tower.setNorth(hall5_2);
        
        
        getRooms().add(kitchen);
        getRooms().add(livingroom);
        getRooms().add(hall2);
        getRooms().add(hall3);
        getRooms().add(hall4);
        getRooms().add(hall5);
        getRooms().add(hall6);
        getRooms().add(hall7);
        getRooms().add(hall8);
        getRooms().add(hall9);
        getRooms().add(hall10);
        getRooms().add(hall11);
        getRooms().add(hall12);
        getRooms().add(hall13);
        getRooms().add(hall14);
        getRooms().add(hall15);
        getRooms().add(hall16);
        getRooms().add(hall17);
        getRooms().add(hall18);
        getRooms().add(hall19);
        getRooms().add(bathroom1);
        getRooms().add(armory);
        getRooms().add(yard);
        getRooms().add(lander);
        getRooms().add(entryway);
        getRooms().add(library);
        getRooms().add(diningroom);
        getRooms().add(stair);
        getRooms().add(closet);
        //TODO: getRooms().add(stanzadellaservitù);
       
        //obejcts
        Object battery = new Object(1, "batteria", "Un pacco di batterie, chissà se sono cariche.");
        battery.setAlias(new String[]{"batterie", "pile", "pila"});
        bathroom1.getObjects().add(battery);
        ObjectContainer wardrobe = new ObjectContainer(2, "armadio", "Un semplice armadio.");
        wardrobe.setAlias(new String[]{"guardaroba", "vestiario"});
        wardrobe.setOpenable(true);
        wardrobe.setPickupable(false);
        wardrobe.setOpen(false);
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
        setCurrentRoom(entryway);
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
