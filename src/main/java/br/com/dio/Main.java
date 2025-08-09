package br.com.dio;

import br.com.dio.exception.ApplicationException;
import br.com.dio.persistence.migration.MigrationStrategy;
import br.com.dio.ui.MainMenu;

import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;


public class Main {

    public static void main(String[] args) throws SQLException {
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        } catch (ApplicationException ex) {
            System.err.println("Erro inesperado: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Ocorreu um erro não tratado: " + ex.getMessage());
            ex.printStackTrace();
        }
        new MainMenu().execute();
    }

}
