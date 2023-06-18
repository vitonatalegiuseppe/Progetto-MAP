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
        String darkHall = "Grazie alla luce della luna e delle stelle riesci a distinguere i contorini del corridoio e delle pareti, ma nulla di più. Hai bisogno di qualcosa per illuminaaare meglio.";
        String darkRoom = "Purtroppo, non riesci a distinguere nulla. La stanza è troppo buia. Hai bisogno di qualcosa per illuminarla. Oppure cammina e tanta fortuna!!!";
        String darkHall_2 = "Purtroppo, non riesci a distinguere nulla. Il corridoio è troppo buio. Ogni tanto noti delle strane ombre. Hai bisogno di qualcosa per illuminarla. Oppure cammina e tanta fortuna!!!";
        //ground floor
        Room stairs = new Room(1, "Scale", "É una stanza completamente spoglia: non ci sono arredi di alcun tipo. L'unica cosa che contiene sono le scale che portano al piano superiore.", darkRoom);
        Room hall2 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A ovest e a nord il corridoio prosegue. A sud trovi un cancello; mentre a est una porta aperta.", darkHall);
        Room hall3 = new Room(3, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue.",darkHall);
        // TODO: Ricordarsi di inserire questa descrizione quando entra la prima volta nel primo corridoio: Aprendo porta ti trovi sotto a un porticato che percorre tutto il perimetro del cortile. Da dove ti trovi riesci a vedere che dal sotto il porticato si trovano diversi ingressi a varie stanze. 
        Room hall4 = new Room(4, "Corridoio", "Sei nel corridoio. di per se non c'e' niente di particolare. Riesci a vedere il giardino. A nord, infatti, trovi il suo entrata, mentre a sud hai la prota per"
                + " andare nell'ingresso. A est e ovest il corridoio prosegue.", darkHall);        
        Room hall5 = new Room(5, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e a ovest il corridoio prosegue.", darkHall);
        Room hall6 = new Room(6, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord, sud ed est il corridoio prosegue.", darkHall);
        Room hall7 = new Room(7, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A nord e a sud il corridoio prosegue. A ovest c'è l'ingresso di una stanza.", "Grazie alla luce proveniente da una porta aperta ad ovest, "
                + "riesci a vedere qualcosina, quanto meno a distinguere l'ingresso da cui proviene e che il corridoio prosegue. ");
        Room hall8 = new Room(8, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A est c'è l'ingresso per il giardino.", darkHall);
        Room hall9 = new Room(9, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue.", darkHall);
        Room hall10 = new Room(10, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A ovest vi è l'ingresso di una stanza.", darkHall);
        Room hall11 = new Room(11, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A sud e a est il corridoio prosegue.", darkHall);
        Room hall12 = new Room(12, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue.", darkHall);
        Room hall13 = new Room(13, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A est e a ovest il corridoio prosegue. A nord come a sud c'è un ingresso.", darkHall);
        Room hall14 = new Room(14, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e a ovest il corridoio prosegue. A nord vi è l'ingresso di una stanza.", darkHall);
        Room hall15 = new Room(15, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. Noti che sulle pareti che ti circondano ci sono delle enormi crepe. A ovest e a sud "
                + "il corridoio prosegue.", darkHall);
        Room hall16 = new Room(16, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. Noti che sulle pareti che ti circondano ci sono delle enormi crepe. A nord e sud il "
                + "corridoio prosegue.", darkHall);
        Room hall17 = new Room(17, "Corridoio", "Sei nel corridoio. Riesci a vedere il giardino. A nord e a sud il corridoio prosegue. A est c'è lingresso di una stanza, mentre a ovest l'ingresso al cortile.", darkHall);
        Room hall18 = new Room(18, "Corridoio", "Sei nel corridoio. Riesci a vedere il cortile. A est e ovest il corridoio prosegue.", darkHall);
        Room hall19 = new Room(30, "Corridoio", "Sei nel corridoio. A nord il corridoio prosegue. A sud e ovest vedi una porta.", darkHall);
        Room entryway = new Room(19, "Ingresso", "Sei nell'ingresso. Guardandoti intorno non noti niente di particolare. È un ingresso come tanti: c’è un tappeto con sopra un tavolino, alle pareti ci sono "
                + "dei quadri e il tipico lampadario dell’epoca. A nord c'è una porta mentre sulla parete sud c'è la porta dell'ingresso principale e ci sono un paio di finestre: entrambe però sono sbarrate. "
                + "(Ti sarebbe piaciuto fuggire così in fretta?!!!).",darkRoom);
        Room closet = new Room(20, "Ripostiglio", "Illuminando la stanza vedi che c'è uno scaffale sul lato, mentre infondo alla stanza vedi quello che sembra un generatore. Ovviamente a Nord trovi l'ingresso da cui sei entrato", darkRoom);
        Room library = new Room(21, "Biblioteca", "Entrando ti trovi difronte un tavolo. Vi è un'unica grande libreria che segue le pareti dell'intera stanza. A est c'è la porta da cui sei entrato alla cui destra "
                + "c’è un mobile con sopra un grande libro: “Registro dei libri”.", darkRoom);
        library.setLook("L'intera libreria è divisa in 5 scaffali. Non tutti gli scaffali sono pieni e sembra che manchi qualche libro. Noti, infatti, che ci sono degli spazi vuoti. Infine, noti che sul tavolo c'è un"
                + " bigliettino con su scritto qualcosa.");
        Room livingroom = new Room(22, "Soggiorno", "Entrando ti trovi davanti un grande camino acceso ai cui lati ci sono due poltrone. Intravedi anche una scrivania. (Ah, ovviamente a est c'è la porta da cui sei entrato)", "La luce fioca "
                + "emanata dal fuoco nel camino ti permette di distinguere abbastanza tutto: ci sono due poltrone e intravedi una scrivania");
        livingroom.setLook("Osservando meglio sulla scrivania si intravedono dei fogli. Mentre appese alla kappa del camino noti appese delle fiaccole spente.");
        Room diningroom = new Room(23, "Sala da pranzo", "Sei in un enorme sala da pranzo. C’è un tavolo tutto imbandito con tutto il necessario. Ad un angolo del tavolo noti un uomo, forse il maggiordomo della"
                + " villa. A nord intravedi un ingresso verso un'altra stanza: forse la cucina. (Ah, ovviamente a est c'è la porta da cui sei entrato)", darkRoom);
        Room kitchen = new Room(24, "Cucina", "Niente di particolare. Una cucina come tante: credenze, forno, frigorifero e cassetti ci sono tutti. Sulla parete sud è presente un ingresso probabilmente verso"
                + "la sala da pranzo, mentre sulla parete est c'è una porta che forse conduce alla dispensa.", darkRoom);
        Room lander = new Room(25, "Dispensa", "La dispensa sembra ben rifornita. Oltre a sacchi di farina e vari salumi e formaggi puoi notare una piccola cantina di vini. A ovest dell'ingresso vi "
                + "è una porta che conduce in un'altra stanza, mentre a sud vi è la porta che conduce al corridoio.", darkRoom);
        lander.setLook("Osservando la cantina noti una bottiglia di vino al cui interno brilla una chiave.");
        Room roomOfDebris = new Room(26, "Stanza crollata", "Praticamente è un cumulo di macerie. Non c’è niente se non pietre e qualche foglio/pezzo di carta.", darkRoom);
        Room armory = new Room(27, "Armeria", "Delle candele accese ti permettono di vedere. Oltre ad un’immensa collezione di fucili, pistole e lance puoi notare anche una serie di oggetti che non sono propriamente armi: caschi, armature, rampini,"
                + " scarpe, occorrenti per giardinaggio, ecc. Inoltre, vedi anche delle panche. Alle tue spalle, sulla parete nord c'è l'ingresso da cui sei entrato. Ma ad attirare la tua attenzione"
                + "è l'echeggiare di rumore.", "");
        armory.setLook("Una panca, in particolare, attira la tua attenzione: su di essa c’è un uomo che dorme. Appena lo focalizzi ti balza all’occhio la chiave che gli pende dal collo.");
        Room bathroom1 = new Room(28, "Bagno", "É un normale bagno. Water, bidet, lavandino e vasca. Niente di particolare, se non fosse che a un angolo della vasca vedi una figura."
                + "É un po' strana: sembra trasparente. Appena ti avvicini noti che riesci a vederci attraverso: si tratta di un fantasma!!!! (Ah, ovviamente a ovest c'è la porta da cui sei entrato.)", darkRoom);
        Room yard = new Room(29, "Cortile", "Al suo interno vedi alberi, cespugli, fiori e siepi.", "La luce della luna e delle stelle ti permette di distinguere i contorni di quello che ti circonda, ma nulla più. "
                + "Hai bisogno di qualcosa che illumini, altrimenti non riuscirai a trovare nulla. ");
        yard.setLook("Guardando meglio, la prima cosa che ti balza all’occhio è un enorme cilindro che sembra alto circa 3 metri al cui interno c’è una chiave esposta. Ti rendi conto anche che una parte del cortile"
                + " è coperta da un balcone che sembra essere l’affaccio di qualche stanza del primo piano.");
        
        //secondo piano
        Room stairs_2 = new Room(31, "Scale", "Salendo ti ritrovi un’ampia stanza da cui, ben presto, capisci che si tratta di un corridoio che circonda l’intero palazzo.", darkRoom);
        stairs_2.setLook("C'è ben poco arredamento: un tappeto posizionato al centro della stanza sembra percorrere l’intero corridoio, ci sono delle sculture.");
        Room hall2_2 = new Room(32, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finestra."
                + " A ovest e a nord il corridoio prosegue. A sud vai verso le scale.", darkHall_2);
        Room hall3_2 = new Room(33, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue. A sud vai verso le scale.", darkHall_2);
        Room hall4_2 = new Room(34, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finestra."
                + " A ovest e a est il corridoio prosegue. A nord vi è l'ingresso di una stanza.", darkHall_2);
        Room hall5_2 = new Room(35, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso. A sud, dove dovrebbe esserci l'ingresso per la torre c’è una scultura. "
                + " A ovest e a est il corridoio prosegue.", darkHall_2);
        hall5_2.setLook("La scultura raffigura un dio Ares, il dio greco della guerra, in una posa particolare: è in piedi con il braccio sinistro che regge uno scudo, mentre il"
                + " braccio desto mantiene una spada sollevata.");
        Room hall6_2 = new Room(36, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a est il corridoio prosegue. ", darkHall_2);
        Room hall7_2 = new Room(37, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. ", darkHall_2); 
        Room hall8_2 = new Room(38, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri. C'è anche una finesta s, rigorosamente sbarrata."
                + " A nord e a sud il corridoio prosegue. ", darkHall_2);
        Room hall9_2 = new Room(39, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A est entri in una stanza", darkHall_2);
        Room hall10_2 = new Room(40, "Corridoio", "Sei nel corridoio. L'ambiente è pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue.", darkHall_2);
        Room hall11_2 = new Room(41, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A est c'è una porta chiusa", darkHall_2); //TODO: aggoingere porta chiusa 
        Room hall12_2 = new Room(42, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A sud e a est il corridoio prosegue.", darkHall_2);
        Room hall13_2 = new Room(43, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest e a est il corridoio prosegue.", darkHall_2);
        Room hall14_2 = new Room(44, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A ovest il corridoio prosegue. A sud c'è lingresso ad una stanza. A est vedi il nulla: il cielo risplende. Difronte a te c'è "
                + "un precipizio. Probabilmente questa parte della casa è crollata un po' di tempo fa. ", darkHall_2);
        Room hall18_2 = new Room(46, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A sud il corridoio prosegue. A nord vedi il nulla: il cielo risplende. Difronte a te c'è un precipizio. Probabilmente questa "
                + "parte della casa è crollata un po' di tempo fa.", darkHall_2);
        Room hall19_2 = new Room(47, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue. A ovest c'è l'ingresso di una stanza. ", darkHall_2);
        Room hall20_2 = new Room(48, "Corridoio", "Sei nel corridoio. L'ambiente rimane pressochè lo stesso: ci sono delle sculture e dei quadri."
                + " A nord e a sud il corridoio prosegue.", darkHall_2);
        
        Room anteroom = new Room(51, "Anticamera", "La prima cosa che ti colpisce entrando è l’enorme finestrone aperto che affaccia sul cortile. "
                + "Ad entrambi i lati della stanza ci sono delle porte, una chiusa e l’altra aperta. Al centro ci sono dei divani posti intorno ad un tavolino da caffè su cui ci sono delle riviste di abiti da sposa. ", darkRoom);
        Room bedroomBoy = new Room(55, "Camera da letto del figlio", "Sei nella camera da letto di un bambino.\n Non ci sono altri ingressi a parte quello cui sei entrato, c'è un armadio, un letto, un comodino e una scrivania.",darkRoom);
        bedroomBoy.setLook("Osservando meglio la stanza la tua attenzione cade sulla scrivania: noti che ci sono delle foto.");
        Room bedroomGirl = new Room(52, "Camera da letto della figlia", "Sei nella camera da letto di una bambina.\n Non ci sono altri ingressi se non quello da cui sei entrato, vedi un letto con il comodino,"
                + " un armadio la cui anta è aperta: si intravedono abiti da bambina. Infine c'è un mobile con uno specchio.", darkRoom);
        Room bathroom_2 = new Room(53, "Bagno", "Normale bagno. Contiene un quadro che raffigura una persona che si arrampica dal piano terra al balcone con una corda. A est c'è l'ingresso da cui sei entrato", darkRoom);
        Room studio = new Room(56, "Studio", "C’è una scrivania centrale con dei documenti. Davanti ad essa ci sono delle sedie, mentre dietro c’è un piccolo camino. A nord c’è una piccola vetrinetta al cui interno ci sono dei "
                + "liquori e dei bicchieri di vetro. Accanto alla porta di ingresso c’è un quadro che raffigura due bambini accanto alla statua che c’è all’ingresso.", darkRoom);
        studio.setLook("Osservando meglio i documenti si nota in cima una lettera. L'attenzione maggiore, però, l’attira il quadro appeso alla parete: noti, infatti, che alle spalle di Ares si intravede un ingresso e a differenza"
                + " della statua vista in precedenza questa ha il braccio destro con la lama che punta verso il basso.");
        Room mainRoom_1 = new Room(57, "Camera padronale", "Entrando nella stanza ti rendi conto che questa doveva essere la stanza da letto dei proprietari della casa. È enorme!! Al centro c’è un enorme letto a baldacchino. Su "
                + "lato est c’è un enorme cabina armadio, ma parte della stanza, sul lato nord/est, è piena di macerie. C’è anche qui un enorme camino con poste sulla cappa due spade da cavalieri. Davanti al letto c’è un baule "
                + "chiuso. Tutta la stanza è tappezzata di quadri che rappresentano ambienti della casa, o i proprietari o i figli. A sud c’è un enorme finestra chiusa che dà su un balcone che si affaccia sul cortile. (Ovviamente "
                + "a nord c'è lingresso da cui sei entrato) ", darkRoom);
        mainRoom_1.setLook("Avvicinandoti al letto noti che c'è qualcuno che sembra dormire. Non appena ti avvicini, l'uomo si alza...");
        Room mainRoom_2 = new Room(45, "Camera padronale", "Entrando nella stanza ti rendi conto che questa doveva essere la stanza da letto dei proprietari della casa. È enorme!! Al centro c’è un enorme letto a baldacchino. Su "
                + "lato est c’è un enorme cabina armadio, ma parte della stanza, sul lato nord/est, è piena di macerie. C’è anche qui un enorme camino con poste sulla cappa due spade da cavalieri. Davanti al letto c’è un baule "
                + "chiuso. Tutta la stanza è tappezzata di quadri che rappresentano ambienti della casa, o i proprietari o i figli. Ovviamente a sud c'è lingresso da cui sei entrato. ", darkRoom);
        Room tower = new Room(58, "TOrre", "Attraversato l'ingresso dietro la statua ti trovi in uno stretto corridoio. Al termine una luce ti attende. Man mano che ti avvicini senti la rabbia che sale, ma allo stesso"
                + " tempo paura nel temere per quello che può aver fatto quel pazzo alla tua amata Stecy. É li che è tenuta nascosta? Come stara? Arrivato alla fine del corridoio ti trovi difronte colui che ha "
                + "organizzato tutto: Mister X. Il luogo in cui si nasconde, la torre, è una specie di ripostiglio. sembra che ci siano dei mobili, ma questi sono tutti coperti da teli bianchi. L'unico oggetto scoperto,"
                + " una sedia, è quella su cui è legata Stecy. Mister X, invece, è appoggiato a quella che sembra una scrivania.", "");
        Room balconyAnteroom = new Room(61, "Balcone anticamera", "Affacciandoti dal balcone riesci a vdere l'intero cortile e il balcone difronte. li però la finestra sembra chiusa."
                + "A sud trovi l'ingresso alla stanza.", darkRoom);
        Room edge = new Room(62, "Precipizio", "É stato bello conoscerti. Mentre cadi vedi trascorrere tutta la tua vita. ogni tanto colpisci qualche pietra. Mi dispiace, sei morto", "É "
                + "stato bello conoscerti. Mentre cadi vedi trascorrere tutta la tua vita. ogni tanto colpisci qualche pietra. Mi dispiace, sei morto");
        Room balconyMainRoom = new Room(63, "Balcone camera padronale", "Affacciandoti dal balcone riesci a vdere l'intero cortile e il balcone difronte. Li però la finestra sembra aperta."
                + "A nord trovi l'ingresso alla stanza.", darkRoom);
        //map
        stairs.setNorth(hall2);
        entryway.setNorth(hall4);
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
        kitchen.setEast(lander);
        lander.setWest(kitchen);
        lander.setSouth(hall13);
        armory.setWest(hall17);
        bathroom1.setWest(hall2);
        yard.setSouth(hall4);
        yard.setNorth(hall13);
        yard.setWest(hall8);
        yard.setEast(hall17);
        roomOfDebris.setSouth(hall14);
        
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
                out.println(getCurrentRoom().getDescDay());
            }
        }
    }

    private void end(PrintStream out) {
        out.println("Premi il pulsante del giocattolo e in seguito ad una forte esplosione la tua casa prende fuoco...\ntu e tuoi famigliari cercate invano di salvarvi e venite avvolti dalle fiamme...\nè stata una morte CALOROSA...addio!");
        System.exit(0);
    }
}
