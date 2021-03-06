package com.elite.network.server;

import com.elite.game.multiplayer.NetworkGame;

import java.util.ArrayList;

/**
 * Stores the information about players and current game state of a game lobby
 *
 * @author Will Goodman
 */
public class Lobby {

    private final String LOBBY_NAME;
    private ArrayList<Player> players = new ArrayList<>();
    private boolean isPrivate;
    private String hashedPassword;
    private String salt;
    private NetworkGame game;

    /**
     * Creates a new public game lobby
     *
     * @param lobbyName  The name of the lobby
     * @param hostPlayer The name of the player who makes/hosts the lobby
     */
    public Lobby(String lobbyName, Player hostPlayer) {
        this.LOBBY_NAME = lobbyName;
        this.players.add(hostPlayer);
        this.isPrivate = false;
    }

    /**
     * Creates a new private game lobby
     *
     * @param lobbyName      The name of the lobby
     * @param hostPlayer     The name of the player who makes/hosts the lobby
     * @param hashedPassword The hashed password which is used to access the lobby
     * @param salt           The salt which is to be used in conjunction with the password
     */
    public Lobby(String lobbyName, Player hostPlayer, String hashedPassword, String salt) {
        this.LOBBY_NAME = lobbyName;
        this.players.add(hostPlayer);
        this.isPrivate = true;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    /**
     * Gets the lobby's name
     *
     * @return The lobby's name
     */
    public String getName() {
        return this.LOBBY_NAME;
    }

    /**
     * Get's the game state
     *
     * @return The current game state
     */
    public NetworkGame getGame() {
        return this.game;
    }

    /**
     * Sets the game state
     *
     * @param game The current game state
     */
    public void setGame(NetworkGame game) {
        this.game = game;
    }

    /**
     * Gets all players in the lobby
     *
     * @return The list of players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * Sets the list of players in the lobby
     *
     * @param players The new list of players.
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }


    /**
     * @return Whether the lobby is private or not
     */
    public boolean getPrivacy() {
        return this.isPrivate;
    }

    /**
     * @return The salt for the password hash, if the lobby is private, and null if the lobby is public
     */
    public String getSalt() {
        return this.salt;
    }

    /**
     * Adds a new player to the lobby
     *
     * @param player The new player to add
     */
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    /**
     * Removes a player from the lobby
     *
     * @param player The player to remove
     */
    public void removePlayer(Player player) {
        this.players.remove(player);
    }


    /**
     * Checks an entered hashed password against the lobby's hashed password, if the lobby is private.
     *
     * @param hashedPassword The entered hashed password.
     * @return Whether the two hashes match.
     */
    public boolean verifyPassword(String hashedPassword) {
        return this.hashedPassword.equals(hashedPassword);
    }

}