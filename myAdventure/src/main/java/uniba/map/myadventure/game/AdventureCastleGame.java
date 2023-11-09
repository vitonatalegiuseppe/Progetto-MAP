/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package uniba.map.myadventure.game;

import uniba.map.myadventure.interfaces.IndovinelloUI;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uniba.map.myadventure.type.Command;
import uniba.map.myadventure.type.CommandType;
import uniba.map.myadventure.classes.Controller;
import uniba.map.myadventure.classes.Engine;
import uniba.map.myadventure.storage.FileManagement;
import uniba.map.myadventure.classes.GameDescription;
import uniba.map.myadventure.type.ObjectAdv;
import uniba.map.myadventure.type.ObjectAdvContainer;
import uniba.map.myadventure.parser.ParserOutput;
import uniba.map.myadventure.type.PersonAdv;
import uniba.map.myadventure.type.Room;
import uniba.map.myadventure.storage.DatabaseManagement;

/**
 * @author pierpaolo
 */
public class AdventureCastleGame extends GameDescription implements Runnable{
    
    @Override
    public void init() throws Exception {
        FileManagement fileHandler = new FileManagement("./resources/File/descriptionRoom.txt");
        final int NUM_ROOM = 58;
        String[] roomDescription = new String[NUM_ROOM];
        
        //Commands
        Command nord = new Command(CommandType.NORD, "nord");
        nord.setAlias(new String[]{"n", "N", "Nord", "NORD", "nord"});
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
        Command comeUp = new Command(CommandType.COME_UP, "sali");
        comeUp.setAlias(new String[]{"ascendi", "arrampicati", "inerpicati"});
        getCommands().add(comeUp);
        Command goDown = new Command(CommandType.GO_DOWN, "scendi");
        goDown.setAlias(new String[]{"discendi", "calati"});
        getCommands().add(goDown);
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
        Command close = new Command(CommandType.CLOSE, "chiudi");
        close.setAlias(new String[]{});
        getCommands().add(close);
        Command push = new Command(CommandType.PUSH, "premi");
        push.setAlias(new String[]{"spingi"});
        getCommands().add(push);
        Command fill = new Command(CommandType.FILL, "riempi");
        fill.setAlias(new String[]{"versa", "riempire"});
        getCommands().add(fill);
        Command hit = new Command(CommandType.HIT, "colpisci");
        hit.setAlias(new String[]{"picchia", "colpire", "aggredisci", "distruggi"});
        getCommands().add(hit);
        Command hurl = new Command(CommandType.HURL, "lancia");
        hurl.setAlias(new String[]{"lanciare", "scaglia", "getta"});
        getCommands().add(hurl);
        Command drink = new Command(CommandType.DRINK, "bevi");
        drink.setAlias(new String[]{"sorsegia", "scola", "tracanna"});
        getCommands().add(drink);
        Command empty = new Command(CommandType.EMPTY, "svuota");
        empty.setAlias(new String[]{"vuota", "libera"});
        getCommands().add(empty);
        
        //Rooms 
        roomDescription = fileHandler.readString(NUM_ROOM);
        
        //Ground floor
        Room exit = new Room(0, "Esterno", roomDescription[0]);
        Room stairs = new Room(1, "Scale", roomDescription[1]);
        Room hall2 = new Room(2, "Corridoio", roomDescription[2]);
        Room hall3 = new Room(3, "Corridoio", roomDescription[3]);
        Room hall4 = new Room(4, "Corridoio", roomDescription[4]);
        Room hall5 = new Room(5, "Corridoio", roomDescription[5]);
        Room hall6 = new Room(6, "Corridoio", roomDescription[6]);
        Room hall7 = new Room(7, "Corridoio", roomDescription[7]);
        Room hall8 = new Room(8, "Corridoio", roomDescription[8]);
        Room hall9 = new Room(9, "Corridoio", roomDescription[9]);
        Room hall10 = new Room(10, "Corridoio", roomDescription[10]);
        Room hall11 = new Room(11, "Corridoio", roomDescription[11]);
        Room hall12 = new Room(12, "Corridoio", roomDescription[12]);
        Room hall13 = new Room(13, "Corridoio", roomDescription[13]);
        Room hall14 = new Room(14, "Corridoio", roomDescription[14]);
        Room hall15 = new Room(15, "Corridoio", roomDescription[15]);
        Room hall16 = new Room(16, "Corridoio", roomDescription[16]);
        Room hall17 = new Room(17, "Corridoio", roomDescription[17]);
        Room hall18 = new Room(18, "Corridoio", roomDescription[18]);
        Room hall19 = new Room(19, "Corridoio", roomDescription[19]);
        Room entryway = new Room(20, "Ingresso", roomDescription[20]);
        Room closet = new Room(21, "Ripostiglio", roomDescription[21]);
        Room library = new Room(22, "Biblioteca", roomDescription[22]);
        library.setLook("Osservando meglio la stanza noti che sul tavolo ci sono diverse carete. quella che ti attire di più è un bigliettino con su lo stemma di Mister X");
        Room livingroom = new Room(23, "Soggiorno", roomDescription[23]);
        livingroom.setLook("Osservando meglio sulla scrivania si intravedono dei fogli.");
        Room diningroom = new Room(24, "Sala da pranzo", roomDescription[24]);
        Room kitchen = new Room(25, "Cucina", roomDescription[25]);
        Room larder = new Room(26, "Dispensa", roomDescription[26]);
        larder.setLook("Guardandoti in giro il tuo sguardo viene attirato dalla piccola cantina di vini. In particolare, noti una bottiglia di vino al cui interno brilla qualcosa.");
        Room roomOfDebris = new Room(27, "Stanza crollata", roomDescription[27]);
        Room armory = new Room(28, "Armeria", roomDescription[28]);
        Room bathroom1 = new Room(29, "Bagno", roomDescription[29]);
        Room yard = new Room(30, "Cortile", roomDescription[30]);
        yard.setLook("Ti rendi conto che una parte del cortile è coperta da un balcone che sembra essere l’affaccio di qualche stanza del primo piano.");
        
        //secondo piano
        Room stairs_2 = new Room(31, "Scale", roomDescription[31]);
        stairs_2.setLook("C'è ben poco arredamento: un tappeto posizionato al centro della stanza sembra percorrere l’intero corridoio, ci sono delle sculture.");
        Room hall2_2 = new Room(32, "Corridoio", roomDescription[32]);
        Room hall3_2 = new Room(33, "Corridoio", roomDescription[33]);
        Room hall4_2 = new Room(34, "Corridoio", roomDescription[34]);
        Room hall5_2 = new Room(35, "Corridoio", roomDescription[35]);
        hall5_2.setLook("La scultura raffigura un dio Ares, il dio greco della guerra, in una posa particolare: è in piedi con il braccio sinistro che regge uno scudo, mentre il"
                + " braccio desto mantiene una spada sollevata.");
        Room hall6_2 = new Room(36, "Corridoio", roomDescription[36]);
        Room hall7_2 = new Room(37, "Corridoio", roomDescription[37]);
        Room hall8_2 = new Room(38, "Corridoio", roomDescription[38]);
        Room hall9_2 = new Room(39, "Corridoio", roomDescription[39]);
        Room hall10_2 = new Room(40, "Corridoio", roomDescription[40]);
        Room hall11_2 = new Room(41, "Corridoio", roomDescription[41]);
        Room hall12_2 = new Room(42, "Corridoio", roomDescription[42]);
        Room hall13_2 = new Room(43, "Corridoio", roomDescription[43]);
        Room hall14_2 = new Room(44, "Corridoio", roomDescription[44]);
        Room hall18_2 = new Room(45, "Corridoio", roomDescription[45]);
        Room hall19_2 = new Room(46, "Corridoio", roomDescription[46]);
        Room hall20_2 = new Room(47, "Corridoio", roomDescription[47]);
        Room anteroom = new Room(48, "Anticamera", roomDescription[48]);
        Room bedroomBoy = new Room(49, "Camera da letto del figlio", roomDescription[49]);
        Room bedroomGirl = new Room(50, "Camera da letto della figlia", roomDescription[50]);
        Room bathroom_2 = new Room(51, "Bagno", roomDescription[51]);
        Room studio = new Room(52, "Studio", roomDescription[52]);
        studio.setLook("Osservando meglio i documenti si nota in cima una lettera. L'attenzione maggiore, però, l’attira il quadro appeso alla parete: noti, infatti, che alle spalle di Ares si intravede un ingresso e a differenza"
                + " della statua vista in precedenza questa ha il braccio sinistro con la lama che punta dietro");
        Room mainRoom_1 = new Room(53, "Camera padronale", roomDescription[53]);
        Room mainRoom_2 = new Room(54, "Camera padronale", roomDescription[54]);
        Room tower = new Room(55, "Torre", roomDescription[55]);
        Room balconyAnteroom = new Room(56, "Balcone anticamera", roomDescription[56]);
        Room edge = new Room(57, "Precipizio", roomDescription[57]);
        Room balconyMainRoom = new Room(58, "Balcone camera padronale", roomDescription[58]);
        
        //map
        stairs.setNorth(hall2);
        stairs.setComeUp(stairs_2);
        entryway.setNorth(hall4);
        entryway.setSouth(exit);
        hall2.setEast(bathroom1);
        hall2.setWest(hall3);
        hall2.setNorth(hall18);
        hall2.setSouth(stairs);
        hall3.setEast(hall2);
        hall3.setWest(hall4);
        hall4.setNorth(yard);
        hall4.setSouth(entryway);
        hall4.setEast(hall3);
        hall4.setWest(hall5);
        hall5.setEast(hall4);
        hall5.setWest(hall6);
        hall6.setSouth(hall19);
        hall6.setEast(hall5);
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
        hall13.setNorth(larder);
        hall13.setSouth(yard);
        hall13.setEast(hall14);
        hall13.setWest(hall12);
        hall14.setEast(hall15);
        hall14.setWest(hall13);
        hall14.setNorth(roomOfDebris);
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
        larder.setSouth(hall13);
        armory.setWest(hall17);
        bathroom1.setWest(hall2);
        yard.setSouth(hall4);
        yard.setNorth(hall13);
        yard.setWest(hall8);
        yard.setEast(hall17);
        roomOfDebris.setSouth(hall14);
        
        stairs_2.setNorth(hall2_2);
        stairs_2.setGoDown(stairs);
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
        hall6_2.setEast(hall5_2);
        hall6_2.setNorth(hall7_2);
        hall7_2.setSouth(hall6_2);
        hall7_2.setNorth(hall8_2);
        hall8_2.setNorth(hall9_2);
        hall8_2.setSouth(hall9_2);
        hall9_2.setNorth(hall10_2);
        hall9_2.setSouth(hall8_2);
        hall9_2.setEast(studio);
        hall10_2.setNorth(hall11_2);
        hall10_2.setSouth(hall9_2);
        hall11_2.setNorth(hall12_2);
        hall11_2.setSouth(hall10_2);
        hall12_2.setEast(hall13_2);
        hall12_2.setSouth(hall11_2);
        hall13_2.setEast(hall14_2);
        hall13_2.setWest(hall12_2);
        hall14_2.setEast(edge);
        hall14_2.setWest(hall13_2);
        hall14_2.setSouth(mainRoom_1);
        hall18_2.setNorth(edge);
        hall18_2.setSouth(hall19_2);
        hall19_2.setNorth(hall18_2);
        hall19_2.setSouth(hall20_2);
        hall19_2.setWest(bathroom_2);
        hall20_2.setNorth(hall19_2);
        hall20_2.setSouth(hall2_2);
        bathroom_2.setEast(hall19_2);
        anteroom.setNorth(balconyAnteroom);
        anteroom.setSouth(hall4_2);
        anteroom.setWest(bedroomBoy);
        anteroom.setEast(bedroomGirl);
        bedroomGirl.setWest(anteroom);
        bedroomBoy.setEast(anteroom);
        studio.setNorth(mainRoom_2);
        studio.setWest(hall9_2);
        mainRoom_2.setSouth(studio);
        mainRoom_2.setEast(mainRoom_1);
        mainRoom_1.setNorth(hall14_2);
        mainRoom_1.setSouth(balconyMainRoom);
        mainRoom_1.setEast(mainRoom_2);
        balconyMainRoom.setNorth(mainRoom_1);
        tower.setNorth(hall5_2);
        exit.setNorth(entryway);
        
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
        getRooms().add(larder);
        getRooms().add(entryway);
        getRooms().add(library);
        getRooms().add(diningroom);
        getRooms().add(stairs);
        getRooms().add(closet);
        getRooms().add(roomOfDebris);
        
        getRooms().add(hall2_2);
        getRooms().add(hall3_2);
        getRooms().add(hall4_2);
        getRooms().add(hall5_2);
        getRooms().add(hall6_2);
        getRooms().add(hall7_2);
        getRooms().add(hall8_2);
        getRooms().add(hall9_2);
        getRooms().add(hall10_2);
        getRooms().add(hall11_2);
        getRooms().add(hall12_2);
        getRooms().add(hall13_2);
        getRooms().add(hall14_2);
        getRooms().add(hall18_2);
        getRooms().add(hall19_2);
        getRooms().add(hall20_2);
        getRooms().add(anteroom);
        getRooms().add(bedroomBoy);
        getRooms().add(bedroomGirl);
        getRooms().add(mainRoom_1);
        getRooms().add(mainRoom_2);
        getRooms().add(bathroom_2);
        getRooms().add(studio);
        getRooms().add(tower);
        getRooms().add(balconyAnteroom);
        getRooms().add(balconyMainRoom);
        getRooms().add(edge);
        getRooms().add(exit);
        
        //obejcts primo piano
        // ingresso
        ObjectAdv doorExit = new ObjectAdv(60, "Portone", "Sembrerebbe la porta di ingresso, chissà se si può aprire");
        doorExit.setPickupable(false);
        doorExit.setOpenable(false);
        doorExit.setAlias(new String[]{"porta", "uscita"});
        entryway.getObjects().add(doorExit);
        exit.getObjects().add(doorExit);
        
        // ripostiglio
        ObjectAdvContainer armoire = new ObjectAdvContainer(61, "Armadio", "uno scaffale dove al suo interno sembra ci sono chiodi, martello, corda, nastro, carburante, secchio, palanghino");
        armoire.setPickupable(false);
        armoire.setOpenable(true);
        armoire.setAlias(new String[]{"mobile", "guardaroba"});
        closet.getObjects().add(armoire);
        
        ObjectAdv rope = new ObjectAdv(62, "corda", "una corda molto resistente");
        rope.setAlias(new String[]{"laccio", "fune"});
        armoire.add(rope);
        
        ObjectAdv scotch = new ObjectAdv(63, "scotch", "un semplice nastro adesivo");
        scotch.setFragile(true);
        scotch.setAlias(new String[]{"nastro"});
        armoire.add(scotch);
        
        ObjectAdv fuel = new ObjectAdv(64, "benzina", "una tanica di benzina piena");
        fuel.setAlias(new String[]{"carburante", "tanica", "combustibile"});
        armoire.add(fuel);
        
        ObjectAdv hammer = new ObjectAdv(65, "martello", "un martello molto pratico per ottime martellate");
        hammer.setAlias(new String[]{"mazzola"});
        armoire.add(hammer);
        
        ObjectAdv nails = new ObjectAdv(66, "chiodi", "Dei chiodi molto utili se si ha un martello");
        nails.setAlias(new String[]{"puntine", "viti"});
        armoire.add(nails);
        
        ObjectAdv crowbar = new ObjectAdv(67, "palanghino", "un palanghino utile per qualsiasi idea di scasso vi passi per la testa");
        crowbar.setAlias(new String[]{"leva"});
        armoire.add(crowbar);
        
        // sala da pranzo
        ObjectAdv dish = new ObjectAdv(68, "piatto", "Un piatto vuoto");
        dish.setAlias(new String[]{"stoviglia", "porcellana"});
        dish.setFragile(true);
        diningroom.getObjects().add(dish);
        
        ObjectAdv silverware = new ObjectAdv(69, "posata", "Utili per afferrare cosa c'è nel piatto");
        silverware.setAlias(new String[]{"argenteria"});
        diningroom.getObjects().add(silverware);
        
        ObjectAdv glass = new ObjectAdv(70, "bicchiere", "Utili per bere qualsiasi fluido ");
        glass.setAlias(new String[]{"calice", "tazza"});
        glass.setFragile(true);
        diningroom.getObjects().add(glass);
        
        ObjectAdv candle = new ObjectAdv(71, "candela", "Ottime per illuminare e scaldare un ambiente");
        candle.setAlias(new String[]{"lumino"});
        candle.setFragile(true);
        diningroom.getObjects().add(candle);
        
        ObjectAdv dish2 = new ObjectAdv(72, "piatto2", "Un piatto vuoto");
        dish.setAlias(new String[]{"stoviglia2", "porcellana2"});
        dish.setFragile(true);
        diningroom.getObjects().add(dish2);
        
        ObjectAdv silverware2 = new ObjectAdv(73, "posata2", "Utili per afferrare cosa c'è nel piatto");
        silverware.setAlias(new String[]{"argenteria2"});
        diningroom.getObjects().add(silverware2);
        
        ObjectAdv glass2 = new ObjectAdv(74, "bicchiere2", "Utili per bere qualsiasi fluido ");
        glass.setAlias(new String[]{"calice2", "tazza2"});
        glass.setFragile(true);
        diningroom.getObjects().add(glass2);
        
        ObjectAdv candle2 = new ObjectAdv(75, "candela2", "Ottime per illuminare e scaldare un ambiente");
        candle.setAlias(new String[]{"lumino2"});
        candle.setFragile(true);
        diningroom.getObjects().add(candle2);
        
        PersonAdv butler = new PersonAdv(76, "Ambrogio", "É il magiordomo di questo castello. gurdandolo bene noti due cose: "
                + "al collo ha appesa una chiave e dal suo volto traspare la lieve, se pur marcata, intenzione di farti fuori...", 1);
        butler.setAlias(new String[]{"cameriere", "maggiordomo"});
        butler.setPickupable(false);
        diningroom.getObjects().add(butler);
        
        ObjectAdv key1 = new ObjectAdv(77, "chiave1", "una chiave che probabilmente può aprire una serratura");
        key1.setAlias(new String[]{"chiave1"});
        butler.add(key1);
        
        //oggetti biblioteca
        ObjectAdv card = new ObjectAdv(78, "bigliettino", "Sembra molto interessante"); 
        card.setAlias(new String[]{"foglio", "lettera"});
        library.getObjects().add(card);
        
        ObjectAdv key2 = new ObjectAdv(79, "chiave2", "una chiave utile per aprire una serratura, chissà quale");
        key2.setAlias(new String[]{"chiave2"});
        key2.setVisible(false);
        key2.setPickupable(false);
        library.getObjects().add(key2);
        
        //ogetti soggiorno
        ObjectAdvContainer chimney = new ObjectAdvContainer(80, "Camino", "Un bel caminetto con del fuoco accesso, al cui lato noti un bottone. Se hai con te delle salsicce puoi fare un ottimo spuntino.");
        chimney.setAlias(new String[]{"stufa", "caminetto"});
        chimney.setPickupable(false);
        livingroom.getObjects().add(chimney);
        
        ObjectAdv mail = new ObjectAdv(81, "Lettera", "Uno dei fogli sembra essere diversa dalle altre. Osservandola "
                + "noti la sua firma: MIster X. Lo prendi e leggi meglio quello che c'è scritto:"
                + "Se vuoi rivedere la tua amica, devi venirmi a trovare al piano superiore. Ti do una mano: qualcosa che potrebbe aiutarti"
                + "è all'interno del camino... TI aspetto!!!");
        mail.setAlias(new String[]{"busta", "foglio"});
        livingroom.getObjects().add(mail);
        
        ObjectAdv key3 = new ObjectAdv(82, "chiave3", "Una chiave utile per aprire una serratura, chissà quale");
        key3.setAlias(new String[]{"chiave3"});
        chimney.add(key3);
        
        ObjectAdv gasButton = new ObjectAdv(83, "Bottone del gas", "Sul bottone è scritto \"Gas ON/OF\". Probabilmente premendolo farà spegnere o accendere il camino.");
        gasButton.setAlias(new String[]{"Bottone", "Interruttore", "manopola"});
        gasButton.setPushable(true);
        gasButton.setVisible(false);
        gasButton.setPickupable(false);
        livingroom.getObjects().add(gasButton);
        
        //oggetti dispensa
        ObjectAdvContainer winecellar = new ObjectAdvContainer(84, "cantina", "una preziosa scorta di vini profumati ed inebrianti ottimi per le migliori feste da palazzo");
        winecellar.setAlias(new String[]{"deposito", "scantinato"});
        winecellar.setPickupable(false);
        larder.getObjects().add(winecellar);
        
        ObjectAdvContainer winebottle = new ObjectAdvContainer(85, "bottiglia", "Una normale bottiglia al cui interno sembra esserci una chiave");
        winebottle.setOpenable(true);
        winebottle.setFragile(true);
        winebottle.setFilled(true);
        winebottle.setAlias(new String[]{"vino"});
        winecellar.add(winebottle);

        ObjectAdv key4 = new ObjectAdv(86, "chiave4", "una chiave utile per aprire una serratura, chissà quale");
        key4.setAlias(new String[]{"chiave4"});
        winebottle.add(key4);
        
        //oggetti stanza crollata
        ObjectAdv doorDebris = new ObjectAdv(87, "portaservitu", "Una porta... Chissa se puo essere aperta??!!!");
        doorDebris.setOpenable(true);
        doorDebris.setPickupable(false);
        doorDebris.setAlias(new String[]{"porta"});
        roomOfDebris.getObjects().add(doorDebris);
        hall14.getObjects().add(doorDebris);
        
        //ogetti armeria
        ObjectAdv ax = new ObjectAdv(88, "accetta", "Un arma molto pratica per mozzare teste");
        ax.setAlias(new String[]{"ascia"});
        armory.getObjects().add(ax);
        
        ObjectAdv glaive = new ObjectAdv(89, "falcione", "L'arma prediletta dalla signora morte, molto amata anche dagli agricoltori");
        glaive.setAlias(new String[]{"falce"});
        armory.getObjects().add(glaive);
        
        ObjectAdv spear = new ObjectAdv(90, "lancia", "un arma usata nell'era glaciale per abbattere i mammut, ottima per il suo periodo storico");
        spear.setAlias(new String[]{"giavellotto"});
        armory.getObjects().add(spear);
        
        ObjectAdv sword = new ObjectAdv(91, "spada", "ottima nelle grandi battaglie, questa sembra sia salda al muro");
        sword.setAlias(new String[]{"lama"});
        armory.getObjects().add(sword);
        
        ObjectAdv key5 = new ObjectAdv(92, "chiave5", "una chiave utile per aprire una serratura, chissà quale");
        key5.setAlias(new String[]{"chiave5"});
        armory.getObjects().add(key5);
        
        PersonAdv guardian = new PersonAdv(93, "Guardiano", "Lui è Robert il guardiano di questo castello, a lui non sfugge nulla, neanche quando dorme", 7);
        guardian.setAlias(new String[]{"custode", "sorvegliante"});
        guardian.setPickupable(false);
        armory.getObjects().add(guardian);
        
        //scale che portano al secondo piano
        ObjectAdv gate = new ObjectAdv(94, "cancello", "Questo cancello ti blocca la strada, trova la chiave che lo apre o trova un altro modo per oltrepassarlo");
        gate.setOpenable(true);
        gate.setPickupable(false);
        gate.setAlias(new String[]{"inferiata"});
        stairs.getObjects().add(gate);
        hall2.getObjects().add(gate);
        
        //corridioio secondo piano
        ObjectAdv ares = new ObjectAdv(95, "Statua", "Una statua molto bella che raffigura il dio della guerra, Ares. La sua posa è molto particolare: il braccio destro mantiemne lo scudo, mentre il braccio sinistro punta il pavimento con la spada.");
        ares.setAlias(new String[]{"scultura"});
        ares.setPickupable(false);
        hall5_2.getObjects().add(ares);
        
        ObjectAdv aresArm = new ObjectAdv(96, "Braccio di Ares", "Il braccio sinistro della statua di Ares Punta il pavimento con la spada.");
        aresArm.setAlias(new String[]{"braccio"});
        aresArm.setVisible(false);
        aresArm.setPushable(true);
        aresArm.setPickupable(false);
        hall5_2.getObjects().add(aresArm);
        
        //studio secondo piano
        ObjectAdv mail2 = new ObjectAdv(97, "Lettera2", "Caro James, se stai leggendo questa lettera vuole dire che sono fuggito, mi avevano quasi preso quei maledetti cosacchi."
                + " Menomale che mio nonno fece costruire un passaggio segreto: lo usava per fuggire dal castello dove sgattaiolava per raggiungere le sue giovani amiche del bordello. "
                + "Inoltre questo passaggio portava in cima ad una torre dove nascondeva la sua collezione di vini. Il passaggio è raffigurato in un quadro, trova l'ingresso e portami una di quelle bottiglie."
                + "Ti aspetto fuori dalle mura del castello: mi raccomando James non dimenticarti le bottiglie!");
        mail2.setAlias(new String[]{"biglietto"});
        studio.getObjects().add(mail2);
        
        ObjectAdv square = new ObjectAdv(98, "quadro1", "il quadro raffigura la statua di ares il dio della guerra con il braccio sinistro che punta verso dietro. Alle spalle della statua si intravede un corridoio.");
        square.setAlias(new String[]{"dipinto"});
        square.setPickupable(false);
        studio.getObjects().add(square);
        
        // oggetti camera padronaria
        ObjectAdv sword1 = new ObjectAdv(99, "Spada2", "Arma da combattimento ravvicinato");
        sword1.setAlias(new String[]{"lama2", "fioretto2", "scimitarra2"});
        mainRoom_2.getObjects().add(sword1);
        
        ObjectAdv sword2 = new ObjectAdv(100, "Spada3", "Arma da combattimento ravvicinato");
        sword2.setAlias(new String[]{"lama3", "fioretto3", "scimitarra3"});
        mainRoom_2.getObjects().add(sword2);
        
        ObjectAdv window = new ObjectAdv(101, "Finestrone", "Un enorme Finestrone che affaccia sul balcone. Chissa se puo essere aperta??!!!");
        window.setPickupable(false);
        window.setOpen(true);
        window.setOpenable(true);
        window.setAlias(new String[]{"finestra", "lucernario"});
        mainRoom_1.getObjects().add(window);
        balconyMainRoom.getObjects().add(window);
        
        PersonAdv henchman = new PersonAdv(102, "Scagnozzo", "un uomo che sembra stia dormendo... Non far rumore altrimenti lo svegli.", 7);
        henchman.setAlias(new String[]{"lacche", "tirapiedi"});
        henchman.setPushable(true);
        henchman.setPickupable(true);
        mainRoom_1.getObjects().add(henchman);
        
        ObjectAdv chest = new ObjectAdv(103, "Baule", "Un baule della stessa larghezza del letto. sembra chiuso... Vuoi sapere cosa contiene, razza di ficcanaso?!!!");
        chest.setPickupable(false);
        chest.setOpenable(true);
        chest.setAlias(new String[]{"Cassapanca", "forziere"});
        mainRoom_1.getObjects().add(chest);
        
        //oggetti torre
        PersonAdv misterX = new PersonAdv(104, "MisterX", "si presenta con una benda all'occhio, un barbone non curata e un fare minaccioso, il classico tipo losco da non farti mai nemico", 10);
        misterX.setAlias(new String[]{"boss", "cattivo"});
        misterX.setPickupable(false);
        tower.getObjects().add(misterX);
        
        //set starting room
        setCurrentRoom(entryway);
    }
    
    @Override
    public void nextMove(ParserOutput p) {
        
        Controller controller = new Controller();
        boolean opened = false;
        
        if (p.getCommand() == null) {
            Engine.appendToScreenEngine("Non ho capito cosa devo fare! Prova con un altro comando.");
        } else {
            //move
            if (p.getCommand().getType() == CommandType.NORD) {
                identifyObject(getCurrentRoom(), null);
                setCurrentRoom(getCurrentRoom().changeRoom("North", getCurrentRoom()));
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                setCurrentRoom(getCurrentRoom().changeRoom("South", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null);
            } else if (p.getCommand().getType() == CommandType.EAST) {
                setCurrentRoom(getCurrentRoom().changeRoom("East", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null);
            } else if (p.getCommand().getType() == CommandType.WEST) {
                setCurrentRoom(getCurrentRoom().changeRoom("West", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null);
            } else if (p.getCommand().getType() == CommandType.COME_UP) {
                setCurrentRoom(getCurrentRoom().changeRoom("comeUp", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null);
            } else if (p.getCommand().getType() == CommandType.GO_DOWN) {
                setCurrentRoom(getCurrentRoom().changeRoom("goDown", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null);
            } else if (p.getCommand().getType() == CommandType.INVENTORY) {
              
                if(!getInventory().isEmpty()){
                    Engine.appendToScreenEngine("Nel tuo inventario ci sono:");
                    for (ObjectAdv o : getInventory()) {
                        Engine.appendToScreenEngine(o.getName() + ": " + o.getDescription());
                    }
                }else{
                    Engine.appendToScreenEngine("Non ha alcun oggetto nel tuo inventario");
                }
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {
                if (p.getObject() != null) {
                    Engine.appendToScreenEngine(p.getObject().getDescription());
                    identifyObject(null, p.getObject());
                    if(p.getObject() instanceof ObjectAdvContainer){
                        if (p.getObject().isOpen()){
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                            showObjects(c.getList(), c.getName()); 
                        }
                    }
                } else if (p.getInvObject() != null) {
                    Engine.appendToScreenEngine(p.getInvObject().getDescription());
                    identifyObject(null, p.getInvObject());
                    if(p.getInvObject() instanceof ObjectAdvContainer){
                        if (p.getInvObject().isOpen()){
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            showObjects(c.getList(), c.getName());
                        }
                    }  
                }else if (getCurrentRoom().getLook() != null || getCurrentRoom().getObjects().isEmpty() == false) {
                    if (getCurrentRoom().getLook() != null) {
                        Engine.appendToScreenEngine(getCurrentRoom().getLook());
                    }
                    if (!getCurrentRoom().getObjects().isEmpty()) {
                        showObjects(getCurrentRoom().getObjects(), getCurrentRoom().getName()); 
                    }
                } else {
                    Engine.appendToScreenEngine("Non c'è nulla di rillevante qui.");
                }
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {
                if (p.getObject() != null) {
                    if (p.getObject().isPickupable()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        Engine.appendToScreenEngine("Hai raccolto: " + p.getObject().getName() + " - " + p.getObject().getDescription());
                    } else {
                        Engine.appendToScreenEngine("Non puoi raccogliere questo oggetto.");
                    }
                } else {
                    Engine.appendToScreenEngine("Non c'è niente da raccogliere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.OPEN) {
                /*TODO: ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                * Potrebbe non esssere la soluzione ottimale.
                */
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine.appendToScreenEngine("Non c'è niente da aprire qui.");
                } else if (p.getObject() != null) {
                    if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                        p.getObject().setOpen(true);
                        opened = true;
                        Engine.appendToScreenEngine("Hai aperto: " + p.getObject().getName());
                        if (p.getObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                            getCurrentRoom().getObjects().addAll(c.getList());
                            showObjects(c.getList(), c.getName());
                        }
                        identifyObject(null, p.getObject());
                    }
                }else if (p.getInvObject() != null) {
                    if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                        p.getInvObject().setOpen(true);
                        opened = true;
                        Engine.appendToScreenEngine("Hai aperto nel tuo inventario: " + p.getInvObject().getName());
                        if (p.getInvObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            getCurrentRoom().getObjects().addAll(c.getList());
                            showObjects(c.getList(), c.getName());
                        }
                        identifyObject(null, p.getInvObject());
                    }
                }
                if(!opened){
                    Engine.appendToScreenEngine("Non puoi aprire questo oggetto.");
                }
            } else if (p.getCommand().getType() == CommandType.CLOSE) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine.appendToScreenEngine("Non c'è niente da chiudere qui.");
                } else if (p.getObject() != null) {
                    if (p.getObject().isOpenable() && p.getObject().isOpen() == true) {
                        p.getObject().setOpen(false);
                        Engine.appendToScreenEngine("Hai chiuso: " + p.getObject().getName());
                    } else {
                        opened = true;
                    }
                } else if (p.getInvObject() != null) {
                    if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                        p.getInvObject().setOpen(true);
                        Engine.appendToScreenEngine("Hai chiuso nel tuo inventario: " + p.getInvObject().getName());
                    } else {
                        opened = true;
                    }
                }
                if(opened){
                    Engine.appendToScreenEngine("Non puoi chiudere questo oggetto.");
                }
            } else if (p.getCommand().getType() == CommandType.PUSH) {
                if (p.getObject() != null && p.getObject().isPushable()) {
                    Engine.appendToScreenEngine("Hai premuto: " + p.getObject().getName());
                    identifyObject(null, p.getObject());
                } else if (p.getInvObject() != null && p.getInvObject().isPushable()) {
                    Engine.appendToScreenEngine("Hai premuto: " + p.getInvObject().getName());
                    identifyObject(null, p.getInvObject());
                } else {
                    Engine.appendToScreenEngine("Non ci sono oggetti che puoi premere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.HURL) {
                if (p.getObject() != null) {
                    if (p.getInvObject() != null) {
                        if (controller.objectHit()) {
                            Engine.appendToScreenEngine("Hai lanciato: " + p.getInvObject().getName() + " contro " + p.getObject().getName() + " colpendolo");
                            if (p.getObject() instanceof PersonAdv) {
                                PersonAdv person = (PersonAdv) p.getObject();
                                person.setLife(person.getLife() - 1);
                                if (person.getLife() == 0) {
                                    Engine.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                    getCurrentRoom().getObjects().addAll(person.getList());
                                    showObjects(person.getList(), person.getName());
                                    getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                    identifyObject(null, person);
                                } else {
                                    Engine.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                                }
                            } else {
                                if (controller.consequenceOfHurl(p.getObject(), getCurrentRoom(), getInventory())) {
                                    Engine.appendToScreenEngine("L'oggetto " + p.getObject().getName() + " si è distrutto a seguito dello schianto.");
                                    if (p.getObject() instanceof ObjectAdvContainer) {
                                        ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                        showObjects(c.getList(), c.getName());
                                    }
                                } else {
                                    Engine.appendToScreenEngine("L'oggetto " + p.getObject().getName() + " non si è distrutto a seguito dello schianto.");
                                }
                            }
                        } else {
                            Engine.appendToScreenEngine("Hai lanciato: " + p.getInvObject().getName() + " contro " + p.getObject().getName() + " ma non lo hai colpito");
                        }
                        if (controller.consequenceOfHurl(p.getObject(), getCurrentRoom(), getInventory())) {
                            Engine.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " si è distrutto a seguito dello schianto.");
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                showObjects(c.getList(), c.getName());
                            }
                        } else {
                            Engine.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " non si è distrutto a seguito dello schianto.");
                        }
                    } else {
                        Engine.appendToScreenEngine("Tabbaccone, non hai nulla da lanciare");
                        Engine.appendToScreenEngine("Per poter lanciare un oggetto, lo devi prima prendere.");
                    }
                } else if (p.getInvObject() != null) {
                    Engine.appendToScreenEngine("Hai lanciato " + p.getInvObject().getName());
                    if (controller.consequenceOfHurl(p.getInvObject(), getCurrentRoom(), getInventory())) {
                        Engine.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " si è distrutto a seguito dello schianto.");
                        if (p.getInvObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            showObjects(c.getList(), c.getName());
                        }
                    } else {
                        Engine.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " non si è distrutto a seguito dello schianto.");
                    }
                } else {
                    Engine.appendToScreenEngine("Non ci sono oggetti che puoi lanciare");
                }
            } else if (p.getCommand().getType() == CommandType.HIT) {
                if (p.getInvObject() != null) {
                    if (p.getObject() != null) {
                        if (controller.objectHit()) {
                            Engine.appendToScreenEngine("Sei riuscito a colpire " + p.getObject().getName() + " con " + p.getInvObject().getName());
                            if (p.getObject() instanceof PersonAdv) {
                                PersonAdv person = (PersonAdv) p.getObject();
                                person.setLife(person.getLife() - 1);
                                if (person.getLife() == 0) {
                                    Engine.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                    getCurrentRoom().getObjects().addAll(person.getList());
                                    showObjects(person.getList(), person.getName());
                                    getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                    identifyObject(null, person);
                                } else {
                                    Engine.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                                }
                                Engine.appendToScreenEngine(controller.consequenceOfHit(null, p.getInvObject(), getCurrentRoom(), getInventory()));
                            } else {
                                Engine.appendToScreenEngine(controller.consequenceOfHit(p.getObject(), p.getInvObject(), getCurrentRoom(), getInventory()));
                            }
                        } else {
                            Engine.appendToScreenEngine("Non sei riuscito a colpire " + p.getObject().getName() + " con " + p.getInvObject().getName());
                        }
                    } else {
                        Engine.appendToScreenEngine("Hai colpito l'aria con " + p.getInvObject().getName());
                    }
                } else if (p.getObject() != null) {
                    if (controller.objectHit()) {
                        Engine.appendToScreenEngine("Non hai preso alcun oggetto, perciò usi le mani. (Ricorda che devi prima prendere un oggetto e poi utilizzarlo)");
                        Engine.appendToScreenEngine("Sei riuscito a colpire " + p.getObject().getName() + " a mani nude.");
                        if (p.getObject() instanceof PersonAdv) {
                            PersonAdv person = (PersonAdv) p.getObject();
                            person.setLife(person.getLife() - 1);
                            if (person.getLife() == 0) {
                                Engine.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                getCurrentRoom().getObjects().addAll(person.getList());
                                showObjects(person.getList(), person.getName());
                                getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                identifyObject(null, person);
                            } else {
                                Engine.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                            }
                        } else {
                            Engine.appendToScreenEngine(controller.consequenceOfHit(p.getObject(), null, getCurrentRoom(), getInventory()));
                        }
                    } else {
                        Engine.appendToScreenEngine("Non sei riuscito a colpire " + p.getObject().getName());
                    }
                } else {
                    Engine.appendToScreenEngine("Ma come sei bravo a prendere a pugni l'aria!!");
                }
            } else if (p.getCommand().getType() == CommandType.DRINK) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine.appendToScreenEngine("Non c'è niente da bere qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isFillable() && p.getObject().getFilled()) {
                            p.getObject().setFilled(false);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine.appendToScreenEngine("Hai bevuto: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                identifyObject(null, c);
                            } else {
                                Engine.appendToScreenEngine("Hai bevuto: " + p.getObject().getName());
                            }
                        } else {
                            Engine.appendToScreenEngine("Non puoi bere il contenuto di questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isFillable() && p.getInvObject().getFilled()) {
                            p.getInvObject().setFilled(false);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                Engine.appendToScreenEngine("Hai bevuto: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getInventory().addAll(c.getList());
                                showObjects(c.getList(), c.getName());
                            } else {
                                Engine.appendToScreenEngine("Hai bevuto: " + p.getInvObject().getName());
                            }
                        } else {
                            Engine.appendToScreenEngine("Non puoi aprire bere il contenuto di questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.EMPTY) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine.appendToScreenEngine("Non c'è niente da svuotare qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isFillable() && p.getObject().getFilled()) {
                            p.getObject().setFilled(false);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine.appendToScreenEngine("Hai svuotato: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                getCurrentRoom().getObjects().addAll(c.getList());
                                showObjects(c.getList(), c.getName());
                            } else {
                                Engine.appendToScreenEngine("Hai svuotato: " + p.getObject().getName());
                            }
                        } else {
                            Engine.appendToScreenEngine("Non puoi svuotare questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isFillable() && p.getInvObject().getFilled()) {
                            p.getInvObject().setFilled(false);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                Engine.appendToScreenEngine("Hai svuotato: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getInventory().addAll(c.getList());
                                showObjects(c.getList(), c.getName());
                            } else {
                                Engine.appendToScreenEngine("Hai svuotato: " + p.getInvObject().getName());
                            }
                        } else {
                            Engine.appendToScreenEngine("Non puoi svuotare questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.END) {
                end();
            }
        }
    }
    
    private void identifyObject(Room room, ObjectAdv object1){
        Integer idRoom;
        Integer idObject1;
        
        if(room != null){
            idRoom = room.getId();
            switch(idRoom){
                case 58: //è l'ID del precipizio
                    end(); 
                    break;
            }
        }else if(object1 != null){
            idObject1 = object1.getId();
            switch(idObject1){
                case 78:
                    Engine.getGrafica().setEnabled(false);
                    Engine.getGrafica().setVisible(false);
                    IndovinelloUI ind = new IndovinelloUI();
                    ind.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            if(ind.isCompelteRiddles()){
                                Engine.appendToScreenEngine("Dopo aver indovinato l'ultimo libro, senti un rumore alle tue spalle. LA libreria dietro di te si sta aprendo lasciando cadere a terra una chiave. \n");
                                ObjectAdv o = obtainObjectById(getCurrentRoom().getObjects(), 79);
                                if(o.getId() != -1){
                                    o.setPickupable(true);
                                    o.setVisible(true);
                                }
                            }
                            Engine.getGrafica().setEnabled(true);
                            Engine.getGrafica().setVisible(true);
                        }
                    });
                    break;
                case 80: //camino
                    for (ObjectAdv ob : getCurrentRoom().getObjects()) {
                        if(ob.getId() == 83)
                            ob.setVisible(true);
                    }
                    break;
                case 83: //bottone del gas
                    ObjectAdvContainer chimneyForButton = (ObjectAdvContainer) getCurrentRoom().getObjects().get(28);
                    if (chimneyForButton.getName().equals("Camino Spento")){
                        chimneyForButton.setName("Camino");
                        chimneyForButton.setDescription("Un bel caminetto con del fuoco accesso, al cui lato noti un bottone. Se hai con te delle salsicce puoi fare un ottimo spuntino.");
                        Engine.appendToScreenEngine("Prenmendo il bottone, il camino si accende.");
                        chimneyForButton.setOpen(false);
                    } else {
                        chimneyForButton.setName("Camino spento");
                        chimneyForButton.setDescription("Un bel caminetto, al cui lato noti un bottone. Se hai con te delle salsicce purtroppo non puoi fare un ottimo spuntino.");
                        chimneyForButton.setOpen(true);
                        getCurrentRoom().getObjects().add(chimneyForButton.getList().get(30));
                        chimneyForButton.getList().remove(chimneyForButton.getList().get(30));
                        Engine.appendToScreenEngine("Prenmendo il bottone, il camino si spegne rivelando al suo interno tra la cenere una chiave.");
                    }
                    break;
                case 60: //portone
                    if(foundObject(getInventory(), 86)){
                        object1.setOpenable(true);
                        object1.setOpen(true);
                        Engine.appendToScreenEngine("Hai aperto " + object1.getName() + " utilizzando la chiave giusta nell'inventario");
                    } else
                        Engine.appendToScreenEngine("Non puoi aprire " + object1.getName() + " perchè non hai la chiave giusta nell'inventario");
                    break;
                case 94: // cancello sclale
                    if(foundObject(getInventory(), 79)){
                        object1.setOpenable(true);
                        object1.setOpen(true);
                        Engine.appendToScreenEngine("Hai aperto " + object1.getName() + " utilizzando la chiave giusta nell'inventario");
                    } else
                        Engine.appendToScreenEngine("Non puoi aprire " + object1.getName() + " perchè non hai la chiave giusta nell'inventario");
                    break;
                case 95: //statua di Ares
                    for (ObjectAdv ob : getCurrentRoom().getObjects()) {
                        if(ob.getId() == 96) //Braccio di Ares
                            ob.setVisible(true);
                    }
                    break;
                case 87: // porta camera crollata
                    if(foundObject(getInventory(),77)){
                        object1.setOpenable(true);
                        object1.setOpen(true);
                        Engine.appendToScreenEngine("Hai aperto " + object1.getName() + " utilizzando la chiave giusta nell'inventario");
                    } else
                        Engine.appendToScreenEngine("Non puoi aprire " + object1.getName() + " perchè non hai la chiave giusta nell'inventario");
                    break;
                case 96: //Braccio di Ares
                    Engine.appendToScreenEngine("Spingendo il braccio della statua di Ares, dietro la statua si sposta un muro rivelando un passaggio.");
                    Room r = obtainRoomById(getRooms(), 55);
                    if(r.getId() != -1){
                        getCurrentRoom().setSouth(r);
                        setCurrentRoom(getCurrentRoom().changeRoom("South", getCurrentRoom()));
                    }
                    break;
                case 104: //Morte Mister X
                    Engine.appendToScreenEngine("Finalmente Mister X ha tirato le cuoia!!!!!!!");
                    Engine.appendToScreenEngine("Hai salvato Stecy, ora puoi fare quel che ti pare...");
                    Engine.appendToScreenEngine("Prendi Stecy per mano e camminate insieme verso il tramonto.");
                    Engine.appendToScreenEngine("E vissero per sempre felici e contenti.");
                    Engine.appendToScreenEngine("Ci siamo divertiti... Forse");
                    end();
                    break;
            }
        }
    }
    
    private void end() {
        (new Thread(this)).start();
    }
    
    @Override
    public void run() {
        try {
            DatabaseManagement databaseManagement = new DatabaseManagement();
            databaseManagement.saveObjectsToDatabase(getInventory());
            databaseManagement.savePositionRoomToDatabase(getCurrentRoom().getName());
            Engine.appendToScreenEngine("Addioooo...!");
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException e) {
            // Gestisci eventuali eccezioni dovute all'interruzione del sonno
            Logger.getLogger(PersonAdv.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void showObjects(List<ObjectAdv> objectList, String name) {
        if (!objectList.isEmpty()) {
            Engine.appendToScreenEngine("Gli oggetti che vedi in " + name + " sono:");
            objectList.stream()
                    .filter(o -> o.isVisible() == true)
                    .map(o -> o.getName())
                    .forEach(o -> Engine.appendToScreenEngine(o));
        }
    }
    
    private boolean foundObject(List<ObjectAdv> objects, int id){
        boolean found = false;
        Iterator<ObjectAdv> iterator = objects.iterator();

        while (iterator.hasNext() && found == false) {
            if (iterator.next().getId() == id) {
                found = true;
            }
        }
        
        return found;
    }
    
    private ObjectAdv obtainObjectById(List<ObjectAdv> objects, int id){
        ObjectAdv object = new ObjectAdv(-1);
        boolean found = false;
        Iterator<ObjectAdv> iterator = objects.iterator();

        while (iterator.hasNext() && found == false) {
            object = iterator.next();
            if (object.getId() == id) {
                found = true;
            }
        }
        return object;
    }
    
    private Room obtainRoomById(List<Room> rooms, int id){
        Room room = new Room(-1);
        boolean found = false;
        Iterator<Room> iterator = rooms.iterator();

        while (iterator.hasNext() && found == false) {
            room = iterator.next();
            if (room.getId() == id) {
                found = true;
            }
        }
        return room;
    }
}