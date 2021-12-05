package com.example.pertemuan7_1918067;

public class Clashofclans {
    private String _id, _username, _balaikota;
    public Clashofclans(String id, String username, String balaikota) {
        this._id = id;
        this._username= username;
        this._balaikota = balaikota;
    }
    public Clashofclans() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_username() {
        return _username;
    }
    public void set_username(String _username) {
        this._username = _username;
    }
    public String get_balaikota() {
        return _balaikota;
    }
    public void set_balaikota(String _balaikota) {
        this._balaikota = _balaikota;
    }
}
