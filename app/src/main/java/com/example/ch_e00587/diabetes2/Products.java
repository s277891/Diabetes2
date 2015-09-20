package com.example.ch_e00587.diabetes2;

import android.util.Log;

/**
 * Created by CH-E00587 on 9/13/2015.
 */
public class Products {
    private static int _id;
    private static String _name;
    private static String _dob;
    private static int _bp;
    private static int _cholestrol;
    private static int _hypo;
    private static int _glucose;
    private static String _check="abcd";

    public Products() {
    }
    public Products(String name,String dob,int bp,int cholestrol,int hypo,int glucose) {
        this._name=name;
        this._dob=dob;
        this._cholestrol=cholestrol;
        this._bp=bp;
        this._hypo=hypo;
        this._glucose=glucose;
        Log.i("DIABETES1", "On Products");
        Log.i("DIABETES1", "In Products Got name as "+name);
        Log.i("DIABETES1", "In Products Got dob as "+dob);
        Log.i("DIABETES1", "In Products Got bp as "+bp);
        Log.i("DIABETES1", "In Products Got cholestrol as "+cholestrol);
        Log.i("DIABETES1", "In Products Got hypo as "+hypo);
        Log.i("DIABETES1", "In Products Got glucose as "+glucose);
    }

    public static int get_id() {
        return _id;
    }

    public static void set_id(int _id) {
        Products._id = _id;
    }

    public static String get_name() {
        Log.i("DIABETES1","In Products get name "+_name);
        Log.i("DIABETES1","In Products get name "+_check);
        return _name;
    }

    public static void set_name(String _name) {
        Products._name = _name;
    }

    public static String get_dob() {
        return _dob;
    }

    public static void set_dob(String _dob) {
        Products._dob = _dob;
    }

    public static int get_bp() {
        return _bp;
    }

    public static void set_bp(int _bp) {
        Products._bp = _bp;
    }

    public static int get_cholestrol() {
        return _cholestrol;
    }

    public static void set_cholestrol(int _cholestrol) {
        Products._cholestrol = _cholestrol;
    }

    public static int get_hypo() {
        return _hypo;
    }

    public static void set_hypo(int _hypo) {
        Products._hypo = _hypo;
    }

    public static int get_glucose() {
        return _glucose;
    }

    public static void set_glucose(int _glucose) {
        Products._glucose = _glucose;
    }
}
