/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package uniba.map.myadventure.classes;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uniba.map.myadventure.classes.SeAvanzaTempo.h2;

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
        Command play = new Command(CommandType.PLAY, "gioca");
        play.setAlias(new String[]{"inizia"});
        getCommands().add(play);
        
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
        library.setLook("L'intera libreria è divisa in 5 scaffali. Non tutti gli scaffali sono pieni e sembra che manchi qualche libro. Noti, infatti, che ci sono degli spazi vuoti. Infine, noti che sul tavolo c'è un"
                + " bigliettino con su scritto qualcosa.");
        Room livingroom = new Room(23, "Soggiorno", roomDescription[23]);
        livingroom.setLook("Osservando meglio sulla scrivania si intravedono dei fogli. Mentre appese alla kappa del camino noti delle fiaccole spente.");
        Room diningroom = new Room(24, "Sala da pranzo", roomDescription[24]);
        Room kitchen = new Room(25, "Cucina", roomDescription[25]);
        Room larder = new Room(26, "Dispensa", roomDescription[26]);
        larder.setLook("Guardandoti in giro il tuo sguardo viene attirato dalla piccola cantina di vini. In particolare, noti una bottiglia \n"
                + "di vino al cui interno brilla qualcosa.");
        Room roomOfDebris = new Room(27, "Stanza crollata", roomDescription[27]);
        Room armory = new Room(28, "Armeria", roomDescription[28]);
        armory.setLook("Una panca, in particolare, attira la tua attenzione: su di essa c’è un uomo che dorme. Appena lo focalizzi ti balza all’occhio la chiave che gli pende dal collo.");
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
        bedroomBoy.setLook("Osservando meglio la stanza la tua attenzione cade sulla scrivania: noti che ci sono delle foto.");
        Room bedroomGirl = new Room(50, "Camera da letto della figlia", roomDescription[50]);
        Room bathroom_2 = new Room(51, "Bagno", roomDescription[51]);
        Room studio = new Room(52, "Studio", roomDescription[52]);
        studio.setLook("Osservando meglio i documenti si nota in cima una lettera. L'attenzione maggiore, però, l’attira il quadro appeso alla parete: noti, infatti, che alle spalle di Ares si intravede un ingresso e a differenza"
                + " della statua vista in precedenza questa ha il braccio destro con la lama che punta verso il basso.");
        Room mainRoom_1 = new Room(53, "Camera padronale", roomDescription[53]);
        mainRoom_1.setLook("Avvicinandoti al letto noti che c'è qualcuno che sembra dormire. Non appena ti avvicini, l'uomo si alza...");
        Room mainRoom_2 = new Room(54, "Camera padronale", roomDescription[54]);
        Room tower = new Room(55, "TOrre", roomDescription[55]);
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
        kitchen.setEast(larder);
        larder.setWest(kitchen);
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
        ObjectAdv doorExit = new ObjectAdv(64, "Portone", "Sembrerebbe la porta di ingresso, chissà se si può aprire");
        doorExit.setPickupable(false);
        doorExit.setOpenable(false);
        doorExit.setAlias(new String[]{"porta", "uscita"});
        entryway.getObjects().add(doorExit);
        exit.getObjects().add(doorExit);
        
        // ripostiglio
        ObjectAdvContainer armoire = new ObjectAdvContainer(6, "Armadio", "uno scaffale dove al suo interno sembra ci sono chiodi, martello, corda, nastro, carburante, secchio, palanghino");
        armoire.setPickupable(false);
        armoire.setOpenable(true);
        armoire.setAlias(new String[]{"mobile", "guardaroba"});
        closet.getObjects().add(armoire);
        
        ObjectAdv rope = new ObjectAdv(7, "corda", "una corda molto resistente");
        rope.setAlias(new String[]{"laccio", "fune"});
        armoire.add(rope);
        
        ObjectAdv scotch = new ObjectAdv(8, "scotch", "un semplice nastro adesivo");
        scotch.setFragile(true);
        scotch.setAlias(new String[]{"nastro"});
        armoire.add(scotch);
        
        ObjectAdv fuel = new ObjectAdv(9, "benzina", "una tanica di benzina piena");
        fuel.setAlias(new String[]{"carburante", "tanica", "combustibile"});
        armoire.add(fuel);
        
        ObjectAdv hammer = new ObjectAdv(10, "martello", "un martello molto pratico per ottime martellate");
        hammer.setAlias(new String[]{"mazzola"});
        armoire.add(hammer);
        
        ObjectAdv nails = new ObjectAdv(11, "chiodi", "Dei chiodi molto utili se si ha un martello");
        nails.setAlias(new String[]{"puntine", "viti"});
        armoire.add(nails);
        
        //TODO: capire se tenerlo
        ObjectAdvContainer bucket = new ObjectAdvContainer(12, "Secchio vuoto", "un secchio pieno d'acqua");
        bucket.setOpenable(true);
        bucket.setOpen(true);
        bucket.setFillable(true);
        bucket.setAlias(new String[]{"bidone", "secchio"});
        armoire.add(bucket);
        
        ObjectAdv crowbar = new ObjectAdv(13, "palanghino", "un palanghino utile per qualsiasi idea di scasso vi passi per la testa");
        crowbar.setAlias(new String[]{"leva"});
        armoire.add(crowbar);
        
        // sala da pranzo
        // TODO: se avanza il tempo: il cibo all'interno dei piatti è avvelenato e il personaggio perde una vita se lo mangia.
        ObjectAdv dish = new ObjectAdv(15, "piatto", "Un piatto con ancora del cibo al loro interno, chissà se è buono");
        dish.setAlias(new String[]{"stoviglia", "porcellana"});
        dish.setFragile(true);
        diningroom.getObjects().add(dish);
        
        ObjectAdv silverware = new ObjectAdv(16, "posata", "Utili per afferrare cosa c'è nel piatto");
        silverware.setAlias(new String[]{"argenteria"});
        diningroom.getObjects().add(silverware);
        
        ObjectAdv glass = new ObjectAdv(17, "bicchiere", "Utili per bere qualsiasi fluido ");
        glass.setAlias(new String[]{"calice", "tazza"});
        glass.setFragile(true);
        diningroom.getObjects().add(glass);
        
        ObjectAdv candle = new ObjectAdv(19, "candela", "Ottime per illuminare e scaldare un ambiente");
        candle.setAlias(new String[]{"lumino"});
        candle.setFragile(true);
        diningroom.getObjects().add(candle);
        
        AdvPerson butler = new AdvPerson(2, "Ambrogio", "É il magiordomo di questo castello. gurdandolo bene noti due cose: "
                + "al collo ha appesa una chiave e dal suo volto traspare la lieve, se pur marcata, intenzione di farti fuori...", 1);
        butler.setAlias(new String[]{"cameriere", "maggiordomo"});
        butler.setPickupable(false);
        diningroom.getObjects().add(butler);
        //TOTO: da rivedere sto fatto della chiave posseduta dal maggiorndomo
        ObjectAdv key1 = new ObjectAdv(21, "chiave", "una chiave che probabilmente può aprire una serratura");
        key1.setAlias(new String[]{"chiavi"});
        butler.add(key1);
        //TODO: creare una classe persona sottoclasse di oggetti. tra gli attributi c'è vita che indica la vita del personaggio. se la vita arriva a zero la persona muore.
        // il giocatore per recuperare la vita deve mangiare o bere qualcosa.
        
        //oggetti biblioteca
        ObjectAdv card = new ObjectAdv(22, "bigliettino", ""); //TODO: da inserire la descrizione del foglietto
        card.setAlias(new String[]{"foglio", "lettera"});
        //TODO: inserire gli indovinelli che ti conducono alla chiave
        library.getObjects().add(card);
        //TODO: se c'è tempo ampliare i libri dello scaffale e aggiungere nome del libro
        
        ObjectAdvContainer bookcase = new ObjectAdvContainer(23, "scaffale", "nome libro");
        bookcase.setPickupable(false);
        bookcase.setAlias(new String[]{"libreria",});
        library.getObjects().add(bookcase);
        
        ObjectAdv book1 = new ObjectAdv(24, "libro", "questo libro sembra essere piu pulito rispetto a gli altri");
        book1.setPickupable(true);
        book1.setAlias(new String[]{"testo"});
        bookcase.add(book1);
        
        ObjectAdvContainer secretbox = new ObjectAdvContainer(31, "scompartimento", "al suo interno c'è una chiave insieme ad un odore di qualcosa andato a male,"
                + " sembra che qualcuno ci abbia lasciato il pranzo");
        secretbox.setAlias(new String[]{"ripostiglio", "nascondiglio"});
        library.getObjects().add(secretbox);
        
        ObjectAdv key2 = new ObjectAdv(36, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key2.setAlias(new String[]{"chiave"});
        secretbox.add(key2);
        
        //ogetti soggiorno
        //TODO: codificare il fatto di svuotare il secchio sul fuoco
        ObjectAdvContainer chimney = new ObjectAdvContainer(28, "Camino", "Un bel caminetto con del fuoco accesso, al cui lato noti un bottone. Se hai con te delle salsicce puoi fare un ottimo spuntino.");
        chimney.setAlias(new String[]{"stufa", "caminetto"});
        chimney.setPickupable(false);
        livingroom.getObjects().add(chimney);
        
        //TODO: capire se tenerlo
        ObjectAdv flame = new ObjectAdv(70, "Fuoco", "Senti un forte calore che provengono dalle fiamme alte e luninose presenti nel camino.");
        flame.setAlias(new String[]{"fiamme"});
        flame.setPickupable(false);
        
        ObjectAdv mail = new ObjectAdv(29, "Bigliettino", "Uno dei fogli sembra essere diversa dalle altre. Osservandola "
                + "noti la sua firma: MIster X. Lo prendi e leggi meglio quello che c'è scritto:"
                + "Se vuoi rivedere la tua amica, devi venirmi a trovare al piano superiore. Ti do una mano: qualcosa che potrebbe aiutarti"
                + "è all'interno del camino... TI aspetto!!!");
        mail.setAlias(new String[]{"busta", "foglio"});
        livingroom.getObjects().add(mail);
        
        ObjectAdv key3 = new ObjectAdv(30, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key3.setAlias(new String[]{"3"});
        chimney.add(key3);
        
        ObjectAdv gasButton = new ObjectAdv(76, "Bottone del gas", "Sul bottone è scritto \"Gas ON/OF\". Probabilmente premendolo farà spegnere o accendere il camino.");
        gasButton.setAlias(new String[]{"Bottone", "Interruttore", "manopola"});
        gasButton.setPushable(true);
        gasButton.setVisible(false);
        gasButton.setPickupable(false);
        livingroom.getObjects().add(gasButton);
        
        //oggetti cucina
        //TODO: capire se tenerlo
        ObjectAdvContainer kitchenTap = new ObjectAdvContainer(71, "Rubinetto", "Nelle cunice è normale trovare questo oggetto: spesso utilizzato per "
                + "far uscire dell'acqua utile a lavare altri oggetti, a cuocere pietanze e a dissetari.");
        kitchenTap.setOpenable(true);
        kitchenTap.setAlias(new String[] {"Miscelatore"});
        kitchen.getObjects().add(kitchenTap);
        
        //TODO: capire se tenerlo
        ObjectAdvContainer pot = new ObjectAdvContainer(74, "Pentola vuota", "Nelle cunice è normale trovare questo oggetto: spesso utilizzato per "
                + "cuocere pietanze. in genere viene riempito di liquidi e messo a scaldare sul fuoco.");
        pot.setAlias(new String[]{"pentola", "tegame"});
        pot.setOpenable(true);
        pot.setOpen(true);
        pot.setFillable(true);
        kitchen.getObjects().add(pot);
        
        //TODO: capire se tenerlo
        ObjectAdv water = new ObjectAdv(72, "Acqua", "Composto chimico di formula H2O, assai diffuso in natura nei suoi tre stati d’aggregazione: solido, liquido e aeriforme.");
        water.setPickupable(false);
        water.setAlias(new String[] {"h2o"});
        kitchenTap.add(water);
        
        //TODO: inserire degli oggetti nella cucina che permettano di recuperare la vita
        //TODO: se avanza tempo mettere altri oggetti che può prendere.
        //TODO: rivedere la gestione della porta tra cucina e dispensa
        
        //oggetti dispensa
        ObjectAdv doorlarder = new ObjectAdv(25, "porta dispensa", "una porta che collega a qualche stanza, chissa se si può aprire");
        doorlarder.setOpenable(true);
        doorlarder.setPickupable(false);
        doorlarder.setAlias(new String[]{"porta"});
        larder.getObjects().add(doorlarder);
        kitchen.getObjects().add(doorlarder);
        
        ObjectAdv foodstocks = new ObjectAdv(33, "scorte", "qui c'è del cibo per sfamare l'africa");
        foodstocks.setAlias(new String[]{"viveri", "dispensa"});
        larder.getObjects().add(foodstocks);
        
        ObjectAdv winecellar = new ObjectAdv(34, "cantina", "una preziosa scorta di vini profumati ed inebrianti ottimi per le migliori feste da palazzo");
        winecellar.setAlias(new String[]{"deposito", "scantinato"});
        winecellar.setPickupable(false);
        larder.getObjects().add(winecellar);
       
        ObjectAdvContainer winebottle = new ObjectAdvContainer(35, "bottiglia", "Una normale bottiglia al cui interno sembra esserci una chiave");
        winebottle.setOpenable(true);
        winebottle.setFragile(true);
        winebottle.setFilled(true);
        winebottle.setAlias(new String[]{"vino"});
        larder.getObjects().add(winebottle);

        ObjectAdv key4 = new ObjectAdv(36, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key4.setAlias(new String[]{"chiave"});
        winebottle.add(key4);
        //TODO: per simulare che il tizio è ubriaco dopo aver bevuto il vino, si tolgono alcuni punti vita.
        //TODO: se avanza tempo gestire un thread che faccia recuperare la vita dopo che si è ubricacato.
        
        //oggetti stanza crollata
        ObjectAdv doorDebris = new ObjectAdv(26, "portaservitu", "Una porta... Chissa se puo essere aperta??!!!");
        doorDebris.setOpenable(true);
        doorDebris.setPickupable(false);
        doorDebris.setAlias(new String[]{"porta"});
        roomOfDebris.getObjects().add(doorDebris);
        hall14.getObjects().add(doorDebris);
        //TODO: gestire l'accesso alla stanza con la chiave.
        
        //ogetti armeria
        ObjectAdv ax = new ObjectAdv(39, "accetta", "Un arma molto pratica per mozzare teste");
        ax.setAlias(new String[]{"ascia"});
        armory.getObjects().add(ax);
        
        ObjectAdv glaive = new ObjectAdv(40, "falcione", "L'arma prediletta dalla signora morte, molto amata anche dagli agricoltori");
        glaive.setAlias(new String[]{"falce"});
        armory.getObjects().add(glaive);
        
        ObjectAdv spear = new ObjectAdv(41, "lancia", "un arma usata nell'era glaciale per abbattere i mammut, ottima per il suo periodo storico");
        spear.setAlias(new String[]{"giavellotto"});
        armory.getObjects().add(spear);
        
        ObjectAdv sword = new ObjectAdv(42, "spada", "ottima nelle grandi battaglie, questa sembra sia salda al muro");
        sword.setAlias(new String[]{"lama"});
        armory.getObjects().add(sword);
        
        ObjectAdv key5 = new ObjectAdv(43, "chiave", "una chiave utile per aprire una serratura, chissà quale");
        key5.setAlias(new String[]{"chiave"});
        armory.getObjects().add(key5);
        
        AdvPerson guardian = new AdvPerson(44, "Guardiano", "Lui è Robert il guardiano di questo castello, a lui non sfugge nulla, neanche quando dorme", 7);
        guardian.setAlias(new String[]{"custode", "sorvegliante"});
        guardian.setPickupable(false);
        armory.getObjects().add(guardian);
        
        ObjectAdv grapplingHook = new ObjectAdv(45, "rampino", "un oggetto che se lanciato si aggrappa ovunque, ma inutile senza una corda");
        //TODO: inserire l'azione che unisce gli oggetti e modificare la descrizione del rampino
        armory.getObjects().add(grapplingHook);
        //TODO: cambiare le vite dei nemici
        
        // oggetti bagno
        //TODO: capire se tenerlo
        ObjectAdvContainer bathroomTap = new ObjectAdvContainer(73, "Rubinetto", "Nei basgni è normale trovare questo oggetto: spesso utilizzato per "
                + "far uscire dell'acqua, utile a lavare i denti e le mani.");
        bathroomTap.setOpenable(true);
        bathroomTap.setAlias(new String[] {"Miscelatore"});
        bathroom1.getObjects().add(bathroomTap);
        bathroomTap.add(water);
        
        //scale che portano al secondo piano
        ObjectAdv gate = new ObjectAdv(48, "cancello", "Questo cancello ti blocca la strada, trova la chiave che lo apre o trova un altro modo per oltrepassarlo");
        gate.setOpenable(true);
        gate.setPickupable(false);
        gate.setAlias(new String[]{"inferiata"});
        stairs.getObjects().add(gate);
        hall2.getObjects().add(gate);
        
        //TODO: le chiavi devono essere distinte in qualche maniera altrimenti una volta messe nell'inventario daranno problemi.
        //corridioio secondo piano
        ObjectAdv ares = new ObjectAdv(49, "Statua", "Una statua molto bella che raffigura il dio della guerra, Ares. La sua posa è molto particolare: il braccio destro mantiemne lo scudo, mentre il braccio sinistro punta il lampadario con la spada.");
        ares.setAlias(new String[]{"scultura"});
        ares.setPickupable(false);
        hall5_2.getObjects().add(ares);
        
        ObjectAdv aresArm = new ObjectAdv(49, "Braccio di Ares", "Il braccio sinistro della statua di Ares Punta il lampadario con la spada.");
        aresArm.setAlias(new String[]{"braccio"});
        aresArm.setVisible(false);
        aresArm.setPushable(true);
        aresArm.setPickupable(false);
        hall5_2.getObjects().add(aresArm);
        
        //studio secondo piano
        ObjectAdv mail2 = new ObjectAdv(50, "Lettera", "Caro James, se stai leggendo questa lettera vuole dire che sono fuggito, mi avevano quasi preso quei maledetti cosacchi."
                + " Menomale che mio nonno fece costruire un passaggio segreto: lo usava per fuggire dal castello dove sgattaiolava per raggiungere le sue giovani amiche del bordello. "
                + "Inoltre questo passaggio portava in cima ad una torre dove nascondeva la sua collezione di vini. Il passaggio è raffigurato in un quadro, trova l'ingresso e portami una di quelle bottiglie."
                + "Ti aspetto fuori dalle mura del castello: mi raccomando James non dimenticarti le bottiglie!");
        mail2.setAlias(new String[]{"biglietto"});
        studio.getObjects().add(mail2);
        
        //TODO: l'ho modificata 
        ObjectAdv square = new ObjectAdv(51, "quadro", "il quadro raffigura la statua di ares il dio della guerra con un braccio abbassato");
        square.setAlias(new String[]{"dipinto"});
        square.setPickupable(false);
        studio.getObjects().add(square);
        
        //bagno secondo piano
         //TODO: l'ho modificata
        ObjectAdv square2 = new ObjectAdv(52, "quadro", "il quadro raffigura una persona che si arrampica sul balcone dal cortile del castello, usando un rampino, un tizio molto abile");
        square2.setAlias(new String[]{"dipinto"});
        square2.setPickupable(false);
        bathroom_2.getObjects().add(square2);
        
        // oggetti camera padronaria
        ObjectAdv sword1 = new ObjectAdv(53, "Spada", "Arma da combattimento ravvicinato");
        sword1.setAlias(new String[]{"lama", "fioretto", "scimitarra"});
        mainRoom_2.getObjects().add(sword1);
        
        ObjectAdv sword2 = new ObjectAdv(55, "Spada", "Arma da combattimento ravvicinato");
        sword2.setAlias(new String[]{"lama", "fioretto", "scimitarra"});
        mainRoom_2.getObjects().add(sword2);
        
        ObjectAdv doorWardrobe = new ObjectAdv(57, "Porta cabina armadio", "Una porta... Chissa se puo essere aperta??!!!");
        doorWardrobe.setPickupable(false);
        doorWardrobe.setAlias(new String[]{"porta"});
        mainRoom_1.getObjects().add(doorWardrobe);
        
        ObjectAdv window = new ObjectAdv(58, "Finestrone", "Un enorme Finestrone che affaccia sul balcone. Chissa se puo essere aperta??!!!");
        window.setPickupable(false);
        window.setAlias(new String[]{"finestra", "lucernario"});
        mainRoom_1.getObjects().add(window);
        balconyMainRoom.getObjects().add(window);
        
        AdvPerson henchman = new AdvPerson(44, "Scagnozzo", "un uomo che sembra stia dormendo... Non far rumore altrimenti lo svegli.", 7);
        henchman.setAlias(new String[]{"lacche", "tirapiedi"});
        henchman.setPushable(true);
        henchman.setPickupable(true);
        mainRoom_1.getObjects().add(henchman);
        
        ObjectAdv chest = new ObjectAdv(59, "Baule", "Un baule della stessa larghezza del letto. sembra chiuso... Vuoi sapere cosa contiene, razza di ficcanaso?!!!");
        chest.setPickupable(false);
        chest.setOpenable(true);
        chest.setAlias(new String[]{"Cassapanca", "forziere"});
        mainRoom_1.getObjects().add(chest);
        
        //oggetti torre
        AdvPerson misterX = new AdvPerson(53, "MisterX", "si presenta con una benda all'occhio, un barbone non curata e un fare minaccioso, il classico tipo losco da non farti mai nemico", 10);
        misterX.setAlias(new String[]{"boss", "cattivo"});
        misterX.setPickupable(true);
        tower.getObjects().add(misterX);
        
        AdvPerson stecy = new AdvPerson(54, "Stecy", "una bella ragazza con dei lineamenti del viso armoniosi e proporzionati con occhi grandi e luminosi, la classica ragazza acqua e sapone", 3);
        stecy.setAlias(new String[]{"ragazza"});
        stecy.setPickupable(true);
        tower.getObjects().add(stecy);
        
        //set starting room
        setCurrentRoom(closet);
    }
    
    @Override
    public void nextMove(ParserOutput p) {
        
        Controller controller = new Controller();
        boolean opened = false;
        boolean filledContainer = false;
        
        if (p.getCommand() == null) {
            Engine2.appendToScreenEngine("Non ho capito cosa devo fare! Prova con un altro comando.");
        } else {
            //move
            if (p.getCommand().getType() == CommandType.NORD) {
                identifyObject(getCurrentRoom(), null, null);
                setCurrentRoom(getCurrentRoom().changeRoom("North", getCurrentRoom()));
            } else if (p.getCommand().getType() == CommandType.SOUTH) {
                setCurrentRoom(getCurrentRoom().changeRoom("South", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null, null);
            } else if (p.getCommand().getType() == CommandType.EAST) {
                setCurrentRoom(getCurrentRoom().changeRoom("East", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null, null);
            } else if (p.getCommand().getType() == CommandType.WEST) {
                setCurrentRoom(getCurrentRoom().changeRoom("West", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null, null);
            } else if (p.getCommand().getType() == CommandType.COME_UP) {
                setCurrentRoom(getCurrentRoom().changeRoom("comeUp", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null, null);
            } else if (p.getCommand().getType() == CommandType.GO_DOWN) {
                setCurrentRoom(getCurrentRoom().changeRoom("goDown", getCurrentRoom()));
                identifyObject(getCurrentRoom(), null, null);
            } else if (p.getCommand().getType() == CommandType.INVENTORY) {
              
                if(!getInventory().isEmpty()){
                    Engine2.appendToScreenEngine("Nel tuo inventario ci sono:");
                    for (ObjectAdv o : getInventory()) {
                        Engine2.appendToScreenEngine(o.getName() + ": " + o.getDescription());
                    }
                }else{
                    Engine2.appendToScreenEngine("Non ha alcun oggetto nel tuo inventario");
                }
            } else if (p.getCommand().getType() == CommandType.LOOK_AT) {
                if (p.getObject() != null) {
                    Engine2.appendToScreenEngine(p.getObject().getDescription());
                    identifyObject(null, p.getObject(), null);
                    if(p.getObject() instanceof ObjectAdvContainer){
                        if (p.getObject().isOpen()){
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                            showObjects(c.getList(), c.getName()); 
                        }
                    }
                } else if (p.getInvObject() != null) {
                    Engine2.appendToScreenEngine(p.getInvObject().getDescription());
                    identifyObject(null, p.getInvObject(), null);
                    if(p.getInvObject() instanceof ObjectAdvContainer){
                        if (p.getInvObject().isOpen()){
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            showObjects(c.getList(), c.getName());
                        }
                    }  
                }else if (getCurrentRoom().getLook() != null || getCurrentRoom().getObjects().isEmpty() == false) {
                    if (getCurrentRoom().getLook() != null) {
                        Engine2.appendToScreenEngine(getCurrentRoom().getLook());
                    }
                    if (!getCurrentRoom().getObjects().isEmpty()) {
                        showObjects(getCurrentRoom().getObjects(), getCurrentRoom().getName()); 
                    }
                } else {
                    Engine2.appendToScreenEngine("Non c'è nulla di rillevante qui.");
                }
            } else if (p.getCommand().getType() == CommandType.PICK_UP) {
                if (p.getObject() != null) {
                    if (p.getObject().isPickupable()) {
                        getInventory().add(p.getObject());
                        getCurrentRoom().getObjects().remove(p.getObject());
                        Engine2.appendToScreenEngine("Hai raccolto: " + p.getObject().getName() + " - " + p.getObject().getDescription());
                    } else {
                        Engine2.appendToScreenEngine("Non puoi raccogliere questo oggetto.");
                    }
                } else {
                    Engine2.appendToScreenEngine("Non c'è niente da raccogliere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.OPEN) {
                /*TODO: ATTENZIONE: quando un oggetto contenitore viene aperto, tutti gli oggetti contenuti
                * vengongo inseriti nella stanza o nell'inventario a seconda di dove si trova l'oggetto contenitore.
                * Potrebbe non esssere la soluzione ottimale.
                */
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da aprire qui.");
                } else if (p.getObject() != null) {
                    if (p.getObject().isOpenable() && p.getObject().isOpen() == false) {
                        p.getObject().setOpen(true);
                        opened = true;
                        Engine2.appendToScreenEngine("Hai aperto: " + p.getObject().getName());
                        if (p.getObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                            getCurrentRoom().getObjects().addAll(c.getList());
                            showObjects(c.getList(), c.getName());
                        }
                        identifyObject(null, p.getObject(), null);
                    }
                }else if (p.getInvObject() != null) {
                    if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                        p.getInvObject().setOpen(true);
                        opened = true;
                        Engine2.appendToScreenEngine("Hai aperto nel tuo inventario: " + p.getInvObject().getName());
                        if (p.getInvObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            getCurrentRoom().getObjects().addAll(c.getList());
                            showObjects(c.getList(), c.getName());
                        }
                        identifyObject(null, p.getInvObject(), null);
                    }
                }
                if(!opened){
                    Engine2.appendToScreenEngine("Non puoi aprire questo oggetto.");
                }
            } else if (p.getCommand().getType() == CommandType.CLOSE) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da chiudere qui.");
                } else if (p.getObject() != null) {
                    if (p.getObject().isOpenable() && p.getObject().isOpen() == true) {
                        p.getObject().setOpen(false);
                        Engine2.appendToScreenEngine("Hai chiuso: " + p.getObject().getName());
                    } else {
                        opened = true;
                    }
                } else if (p.getInvObject() != null) {
                    if (p.getInvObject().isOpenable() && p.getInvObject().isOpen() == false) {
                        p.getInvObject().setOpen(true);
                        Engine2.appendToScreenEngine("Hai chiuso nel tuo inventario: " + p.getInvObject().getName());
                    } else {
                        opened = true;
                    }
                }
                if(opened){
                    Engine2.appendToScreenEngine("Non puoi chiudere questo oggetto.");
                }
            } else if (p.getCommand().getType() == CommandType.PUSH) {
                if (p.getObject() != null && p.getObject().isPushable()) {
                    Engine2.appendToScreenEngine("Hai premuto: " + p.getObject().getName());
                    identifyObject(null, p.getObject(), null);
                } else if (p.getInvObject() != null && p.getInvObject().isPushable()) {
                    Engine2.appendToScreenEngine("Hai premuto: " + p.getInvObject().getName());
                } else {
                    Engine2.appendToScreenEngine("Non ci sono oggetti che puoi premere qui.");
                }
            } else if (p.getCommand().getType() == CommandType.HURL) {
                if (p.getObject() != null) {
                    if (p.getInvObject() != null) {
                        if (controller.objectHit()) {
                            Engine2.appendToScreenEngine("Hai lanciato: " + p.getInvObject().getName() + " contro " + p.getObject().getName() + " colpendolo");
                            if (p.getObject() instanceof AdvPerson) {
                                AdvPerson person = (AdvPerson) p.getObject();
                                person.setLife(person.getLife() - 1);
                                if (person.getLife() == 0) {
                                    Engine2.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                    getCurrentRoom().getObjects().addAll(person.getList());
                                    showObjects(person.getList(), person.getName());
                                    getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                } else {
                                    Engine2.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                                }
                            } else {
                                if (controller.consequenceOfHurl(p.getObject(), getCurrentRoom(), getInventory())) {
                                    Engine2.appendToScreenEngine("L'oggetto " + p.getObject().getName() + " si è distrutto a seguito dello schianto.");
                                    if (p.getObject() instanceof ObjectAdvContainer) {
                                        ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                        showObjects(c.getList(), c.getName());
                                    }
                                } else {
                                    Engine2.appendToScreenEngine("L'oggetto " + p.getObject().getName() + " non si è distrutto a seguito dello schianto.");
                                }
                            }
                        } else {
                            Engine2.appendToScreenEngine("Hai lanciato: " + p.getInvObject().getName() + " contro " + p.getObject().getName() + " ma non lo hai colpito");
                        }
                        if (controller.consequenceOfHurl(p.getObject(), getCurrentRoom(), getInventory())) {
                            Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " si è distrutto a seguito dello schianto.");
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                showObjects(c.getList(), c.getName());
                            }
                        } else {
                            Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " non si è distrutto a seguito dello schianto.");
                        }
                    } else {
                        Engine2.appendToScreenEngine("Tabbaccone, non hai nulla da lanciare");
                        Engine2.appendToScreenEngine("Per poter lanciare un oggetto, lo devi prima prendere.");
                    }
                } else if (p.getInvObject() != null) {
                    Engine2.appendToScreenEngine("Hai lanciato " + p.getInvObject().getName());
                    if (controller.consequenceOfHurl(p.getInvObject(), getCurrentRoom(), getInventory())) {
                        Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " si è distrutto a seguito dello schianto.");
                        if (p.getInvObject() instanceof ObjectAdvContainer) {
                            ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                            showObjects(c.getList(), c.getName());
                        }
                    } else {
                        Engine2.appendToScreenEngine("L'oggetto " + p.getInvObject().getName() + " non si è distrutto a seguito dello schianto.");
                    }
                } else {
                    Engine2.appendToScreenEngine("Non ci sono oggetti che puoi lanciare");
                }
            } else if (p.getCommand().getType() == CommandType.HIT) {
                if (p.getInvObject() != null) {
                    if (p.getObject() != null) {
                        if (controller.objectHit()) {
                            Engine2.appendToScreenEngine("Sei riuscito a colpire " + p.getObject().getName() + " con " + p.getInvObject().getName());
                            if (p.getObject() instanceof AdvPerson) {
                                AdvPerson person = (AdvPerson) p.getObject();
                                person.setLife(person.getLife() - 1);
                                if (person.getLife() == 0) {
                                    Engine2.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                    getCurrentRoom().getObjects().addAll(person.getList());
                                    showObjects(person.getList(), person.getName());
                                    getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                                } else {
                                    Engine2.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                                }
                                Engine2.appendToScreenEngine(controller.consequenceOfHit(null, p.getInvObject(), getCurrentRoom(), getInventory()));
                            } else {
                                Engine2.appendToScreenEngine(controller.consequenceOfHit(p.getObject(), p.getInvObject(), getCurrentRoom(), getInventory()));
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non sei riuscito a colpire " + p.getObject().getName() + " con " + p.getInvObject().getName());
                        }
                    } else {
                        Engine2.appendToScreenEngine("Hai colpito l'aria con " + p.getInvObject().getName());
                    }
                } else if (p.getObject() != null) {
                    if (controller.objectHit()) {
                        Engine2.appendToScreenEngine("Non hai preso alcun oggetto, perciò usi le mani. (Ricorda che devi prima prendere un oggetto e poi utilizzarlo)");
                        Engine2.appendToScreenEngine("Sei riuscito a colpire " + p.getObject().getName() + " a mani nude.");
                        if (p.getObject() instanceof AdvPerson) {
                            AdvPerson person = (AdvPerson) p.getObject();
                            person.setLife(person.getLife() - 1);
                            if (person.getLife() == 0) {
                                Engine2.appendToScreenEngine("Hai sconfitto " + person.getName() + ".");
                                getCurrentRoom().getObjects().addAll(person.getList());
                                showObjects(person.getList(), person.getName());
                                getCurrentRoom().getObjects().remove(person); //remove the person that is dead
                            } else {
                                Engine2.appendToScreenEngine(person.getName() + " è ferito. Continua così e ti libererai di lui. (Ha ancora " + person.getLife() + " vite)");
                            }
                        } else {
                            Engine2.appendToScreenEngine(controller.consequenceOfHit(p.getObject(), null, getCurrentRoom(), getInventory()));
                        }
                    } else {
                        Engine2.appendToScreenEngine("Non sei riuscito a colpire " + p.getObject().getName());
                    }
                } else {
                    Engine2.appendToScreenEngine("Ma come sei bravo a prendere a pugni l'aria!!");
                }
            } else if (p.getCommand().getType() == CommandType.DRINK) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da bere qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isFillable() && p.getObject().getFilled()) {
                            p.getObject().setFilled(false);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                identifyObject(null, c, null);
                            } else {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getObject().getName());
                            }//TODO: quali sono le conseguenza dell'essere ubriaco?
                        } else {
                            Engine2.appendToScreenEngine("Non puoi bere il contenuto di questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isFillable() && p.getInvObject().getFilled()) {
                            p.getInvObject().setFilled(false);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getInventory().addAll(c.getList());
                                showObjects(c.getList(), c.getName());
                            } else {
                                Engine2.appendToScreenEngine("Hai bevuto: " + p.getInvObject().getName());
                                //TODO: se avanza tempo distinguere gli oggetti edibili da quelli non edibili
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi aprire bere il contenuto di questo oggetto.");
                        }
                    }
                }
            } else if (p.getCommand().getType() == CommandType.EMPTY) {
                if (p.getObject() == null && p.getInvObject() == null) {
                    Engine2.appendToScreenEngine("Non c'è niente da svuotare qui.");
                } else {
                    if (p.getObject() != null) {
                        if (p.getObject().isFillable() && p.getObject().getFilled()) {
                            p.getObject().setFilled(false);
                            if (p.getObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getObject();
                                getCurrentRoom().getObjects().addAll(c.getList());
                                showObjects(c.getList(), c.getName());
                            } else {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getObject().getName());
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi svuotare questo oggetto.");
                        }
                    }
                    if (p.getInvObject() != null) {
                        if (p.getInvObject().isFillable() && p.getInvObject().getFilled()) {
                            p.getInvObject().setFilled(false);
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getObject().getName() + " liberando il contenuto.");
                                ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                getInventory().addAll(c.getList());
                                showObjects(c.getList(), c.getName());
                            } else {
                                Engine2.appendToScreenEngine("Hai svuotato: " + p.getInvObject().getName());
                            }
                        } else {
                            Engine2.appendToScreenEngine("Non puoi svuotare questo oggetto.");
                        }
                    }
                }
            }  else if (p.getCommand().getType() == CommandType.FILL) {
                //TODO: se avanza tempo aggiungere degli attributi sulla dimesione dell'oggetto e controllare se un oggetto può essere riempito o no
                //TODO: attributi fill e fillable devono essere di objectContainer e non di ObjectAdv
                /*if (p.getInvObject() != null) {
                    if (p.getObject() != null) {
                        if(p.getInvObject().isFillable() && p.getInvObject().getFilled() == false){
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                 ObjectAdvContainer c = (ObjectAdvContainer) p.getInvObject();
                                 c.add(object2);
                                 Engine2.appendToScreenEngine("Hai riempito " + object1.getName() + " con " + object2.getName());
                                identifyObject(null, p.getInvObject(), p.getObject());
                            } else{
                                Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito perchè non è un contenitore.");
                            }
                        } else{
                            Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito prchè già pieno");
                        }
                    } else {
                        Engine2.appendToScreenEngine("Quello che deve essere inserito nel contenitore deve essere un oggetto"
                                + " preciso e deve essere presente nella stanza (non nell'inventario).");
                    }
                } else if (p.getInvObject() != null) {
                    if (p.getObject() != null) {
                        if(p.getInvObject().isFillable() && p.getInvObject().getFilled() == false){
                            if (p.getInvObject() instanceof ObjectAdvContainer) {
                                identifyObject(null, p.getInvObject(), p.getObject());
                            } else{
                                Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito perchè non è un contenitore.");
                            }
                        } else{
                            Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito prchè già pieno");
                        }
                    } else {
                        Engine2.appendToScreenEngine("Quello che deve essere inserito nel contenitore deve essere un oggetto"
                                + " preciso e deve essere presente nella stanza (non nell'inventario).");
                    }
                } else {
                    Engine2.appendToScreenEngine("Un'oggetto per essere riempito deve essere nell'inventario.");
                }
                
                if (p.getObject() != null && p.getInvObject() != null) {
                    if(p.getInvObject() instanceof ObjectAdvContainer){
                        if (p.getInvObject().isFillable()){
                            if (p.getInvObject().getFilled() == false) {
                                identifyObject(null, p.getInvObject(), p.getObject());
                            } else{
                                Engine2.appendToScreenEngine(p.getInvObject().getName() + " è già piebo. per poterlo utilizzare svuotalo..");
                            }
                        } else{
                            Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito.");
                        }
                    } else if(p.getObject().isFillable() && p.getObject().getFilled() == false){
                        if (p.getObject() instanceof ObjectAdvContainer) {
                            identifyObject(null, p.getInvObject(), p.getObject());
                        } else{
                            Engine2.appendToScreenEngine(p.getObject().getName() + " non può essere riempito.");
                        }
                    }else{
                        Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito.");
                    }
                }
                
                if (p.getObject() != null && p.getInvObject() != null) {
                    if(p.getObject().isFillable() && p.getObject().getFilled() == false){
                        if (p.getObject() instanceof ObjectAdvContainer) {
                            identifyObject(null, p.getInvObject(), p.getObject());
                        } else{
                            Engine2.appendToScreenEngine(p.getObject().getName() + " non può essere riempito.");
                        }
                    } else{
                        Engine2.appendToScreenEngine(p.getInvObject().getName() + " non può essere riempito.");
                    }
                }*/
            } else if (p.getCommand().getType() == CommandType.PLAY) {
                Engine2.appendToScreenEngine(" \n benvenuto nel gioco");
            } else if (p.getCommand().getType() == CommandType.END) {
                end();
            }
        }
    }
    
    private void identifyObject(Room room, ObjectAdv object1, ObjectAdv object2){
        Integer idRoom;
        Integer idObject1;
        Integer idObject2;
        
        if(room != null && object1 != null && object2 != null){
            idRoom = room.getId();
            idObject2 = object2.getId();
            idObject1 = object1.getId();
        }else if(room != null && object1 != null){
            idRoom = room.getId();
            idObject1 = object1.getId();
        }else if(room != null){
            idRoom = room.getId();
            switch(idRoom){
                case 58: //è l'ID del precipizio
                    end(); 
                    break;
            }
        }else if(object1 != null && object2 != null){
            idObject1 = object1.getId();
            idObject2 = object2.getId();
            
            //TODO: capire se serve ancora
            switch (idObject1) {
                case 71:
                    Engine2.appendToScreenEngine("Hai riempito " + object1.getName() + " con " + object2.getName());
                    break;
                case 73:
                    Engine2.appendToScreenEngine("Hai riempito " + object1.getName() + " con " + object2.getName());
                    break;
            }
        }else if(object1 != null){
            idObject1 = object1.getId();
            switch(idObject1){
                /*TODO: capire se ervono ancora 
                case 71: 
                    Engine2.appendToScreenEngine("Sta scorrendo dell'acqua. Sprecone!!! L'acqua è un bene prezioso."); 
                    break;
                case 73: 
                    Engine2.appendToScreenEngine("Sta scorrendo dell'acqua. Sprecone!!! L'acqua è un bene prezioso."); 
                    break;
                case 35: 
                    ObjectAdvContainer c = (ObjectAdvContainer) object1;
                    getCurrentRoom().getObjects().addAll(c.getList());
                    c.showObjects();
                    break;*/
                case 28:
                    for (ObjectAdv ob : getCurrentRoom().getObjects()) {
                        if(ob.getId() == 76)
                            ob.setVisible(true);
                    }
                    break;
                case 76:
                    ObjectAdvContainer chimneyForButton = (ObjectAdvContainer) getCurrentRoom().getObjects().get(28);
                    if (chimneyForButton.getName().equals("Camino Spento")){
                        chimneyForButton.setName("Camino");
                        chimneyForButton.setDescription("Un bel caminetto con del fuoco accesso, al cui lato noti un bottone. Se hai con te delle salsicce puoi fare un ottimo spuntino.");
                        Engine2.appendToScreenEngine("Prenmendo il bottone, il camino si accende.");
                    } else {
                        chimneyForButton.setName("Camino spento");
                        chimneyForButton.setDescription("Un bel caminetto, al cui lato noti un bottone. Se hai con te delle salsicce purtroppo non puoi fare un ottimo spuntino.");
                        chimneyForButton.setOpen(true);
                        getCurrentRoom().getObjects().add(chimneyForButton.getList().get(30));
                        chimneyForButton.getList().remove(chimneyForButton.getList().get(30));
                        Engine2.appendToScreenEngine("Prenmendo il bottone, il camino si spegne rivelando al suo interno tra la cenere una chiave.");
                    }
                    break;
                case 64: 
                    if(checkObjectInInv(36)){
                        object1.setOpenable(true);
                        object1.setOpen(true);
                        Engine2.grafica.appendToScreen("Hai aperto " + object1.getName() + " utilizzando la chiave giusta nell'inventario");
                    } else
                        Engine2.grafica.appendToScreen("Non puoi aprire " + object1.getName() + " perchè non hai la chiave giusta nell'inventario");
                    break;
                case 48: 
                    if(checkObjectInInv(43)){
                        object1.setOpenable(true);
                        object1.setOpen(true);
                        Engine2.grafica.appendToScreen("Hai aperto " + object1.getName() + " utilizzando la chiave giusta nell'inventario");
                    } else
                        Engine2.grafica.appendToScreen("Non puoi aprire " + object1.getName() + " perchè non hai la chiave giusta nell'inventario");
                    break;
            }
        }
    }
    
    //TODO: Se si riesce a trovare un metodo migliore ben venga
    private void end() {
        (new Thread(this)).start();
    }
    
    @Override
    public void run() {
        
        try {
            //aggiungere il metodo che salva gli oggetti nell'inventario al database
            h2 databaseManagement = new h2();
            databaseManagement.saveObjectsToDatabase(getInventory());
            Engine2.appendToScreenEngine("Addioooo...!");
            Thread.sleep(5000);
            System.exit(0);
        } catch (InterruptedException e) {
            // Gestisci eventuali eccezioni dovute all'interruzione del sonno
            Logger.getLogger(AdvPerson.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void showObjects(List<ObjectAdv> objectList, String name) {
        if (!objectList.isEmpty()) {
            Engine2.appendToScreenEngine("Gli oggetti che vedi in " + name + " sono:");
            objectList.stream()
                    .filter(o -> o.isVisible() == true)
                    .map(o -> o.getName())
                    .forEach(o -> Engine2.appendToScreenEngine(o));
        }
    }
    
    private boolean checkObjectInInv(int id){
        boolean found = false;
        Iterator<ObjectAdv> iterator = getInventory().iterator();

        while (iterator.hasNext() && found == false) {
            if (iterator.next().getId() == id) {
                found = true;
            }
        }
        
        return found;
    }
}