/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author manager
 */
public class connection {
    static Connection connection = null;
    
static Statement statement = null;
static ResultSet rs = null;
public static String fim;
int cont=0;
public void geraBanco()
{
try
{
connection = DriverManager.getConnection("jdbc:sqlite:QuizEtec.db");
statement = connection.createStatement();
statement.setQueryTimeout(20);

statement.executeUpdate ("drop table if exists quest");

statement.executeUpdate ("create table quest ("
+ "id integer primary key autoincrement,"
+ "pergunta text,"
+ "opcao1 text,"
+ "opcao2 text,"
+ "opcao3 text,"
+ "opcao4 text,"
+ "resposta integer)");

statement.executeUpdate ("drop table if exists players");

statement.executeUpdate ("create table players ("
+ "id integer primary key autoincrement,"
+ "Nome text,"
+ "Acertos interger NULL)");

statement.executeUpdate ("insert into quest values (null, 'Qual foi o primeiro vilão dos vingadores?', 'Ultron', 'Loki', 'Thanos', 'Caveira Vermelha', 2)");
statement.executeUpdate ("insert into quest values (null, 'Qual foi a primeira aparição do thanos?', 'Gardiões da Galaxia', 'Vingadores Guerra Infinita', 'Cenas pós creditos de Vingadores', 'Cenas pós creditos de Vingadores 2', 3)");
statement.executeUpdate ("insert into quest values (null, 'Quem criou Ultron?', 'Tony Stark', 'Bruce Banner e Tony', 'Bruce Benner e Thor', 'Thor e Visão', 2)");
statement.executeUpdate ("insert into quest values (null, 'Qual foi o primeiro filme lançado do UCM?', 'Homem de Ferro', 'Capitão América', 'O incrivel Hulk', 'Homem Aranha', 1)");
statement.executeUpdate ("insert into quest values (null, 'Qual foi o último filme lançado pelo UCM? (até 04/05/2019)', 'Vingadores guerra infinita', 'Vingadores Ultimato', 'Capitã Marvel', 'Pantera Negra', 2)");
statement.executeUpdate ("insert into quest values (null, 'Qual foi o primeiro filme que o homem aranha apareceu?', 'Guerra civil', 'Homem de Ferro 2', 'Homem Aranha de volta ao lar', 'Homem Formiga', 2)");
statement.executeUpdate ("insert into quest values (null, 'Quantas possibilidades o Dr. Estranho viu em guerra infinita?', '14.605.000', '14.000.605', '14.065.000', '14.650.000', 2)");
statement.executeUpdate ("insert into quest values (null, 'De que material é feito o escudo do capitão América?', 'Nanotecnologia', 'Tecido', 'Vibranium', 'Adamantium', 3)");
statement.executeUpdate ("insert into quest values (null, 'Qual foi o primeiro vilão do universo cinematográfico da Marvel?', 'Chicote Negro', 'Caveira Vermelha', 'Obadiah Stane', 'Abóminavel', 3)");
statement.executeUpdate ("insert into quest values (null, 'Qual o vilão do filme Homem Aranha', 'Lagarto', 'Escorpião', 'Duende Verde', 'Abutre', 4)");


    JOptionPane.showMessageDialog(null,"Banco Gerado");

}
catch (SQLException e)
{ System.out.println("deu bosta na gravação " + e);}
}

public static void finalixou(){
fim="sim";
} 

    public static String getFim() {
        return fim;
    }

public void fazpergunta(){
        try {
            rs=null;
            rs=statement.executeQuery("SELECT * FROM quest ORDER BY RANDOM() LIMIT 9");
            while(rs.next()){
                Metodos mt=new Metodos();
                mt.setPer(cont, rs.getString("pergunta"));
                mt.setR1(cont, rs.getString("opcao1"));
                mt.setR2(cont, rs.getString("opcao2"));
                mt.setR3(cont, rs.getString("opcao3"));
                mt.setR4(cont, rs.getString("opcao4"));
                mt.setResp_Certa(cont, rs.getInt("resposta"));
                cont++;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
}


public void CadastraPlayer(String nome){

        try {
            statement.executeUpdate ("insert into players (id,Nome) values (null, '"+nome+"')");
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }

}
public void setAcertos(int acert){
        try {
            
            statement.executeUpdate("UPDATE players SET Acertos="+acert+";");
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void Racking(){
    
        try {
            rs=null;
            rs=statement.executeQuery("SELECT * FROM players ORDER BY Acertos");
            cont=0;
            while(rs.next()){
                Metodos mt=new Metodos();
                mt.setRaking(cont, rs.getString("Nome"));
                mt.setAcertos(cont, rs.getInt("Acertos"));
                cont++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }

}


}
