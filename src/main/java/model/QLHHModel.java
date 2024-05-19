package model;

import java.util.ArrayList;

public class QLHHModel {
    private ArrayList<HangHoa> dsHangHoa;
    private String luaChon;
    private String tenFile;

    public QLHHModel() {
        this.dsHangHoa = new ArrayList<>();
        this.luaChon = "";
        this.tenFile = "";
    }

    public QLHHModel(ArrayList<HangHoa> dsHangHoa) {
        this.dsHangHoa = dsHangHoa;
    }

    public ArrayList<HangHoa> getDsHangHoa() {
        return dsHangHoa;
    }

    public void setDsHangHoa(ArrayList<HangHoa> dsHangHoa) {
        this.dsHangHoa = dsHangHoa;
    }
    
    public void insert(HangHoa hh) {
        this.dsHangHoa.add(hh);
    }
    
    public void delete(HangHoa hh) {
        this.dsHangHoa.remove(hh);
    }
    
    public void update(HangHoa hh) {
        this.dsHangHoa.remove(hh);
        this.dsHangHoa.add(hh);
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public boolean kiemTraTonTai(HangHoa hanghoa) {
        for(HangHoa hh: dsHangHoa) {
            if(hh.getMaSanPham() == hanghoa.getMaSanPham())
                return true;
        }
        return false;
    }
}