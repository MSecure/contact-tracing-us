package com.proudcrowd.exposure.storage;

import com.proudcrowd.exposure.datamodel.InstructionDetail;
import java.util.List;
import java.util.Objects;

public class PartyEntity {
    private String constituentName;
    private int id;
    private String imageUrl;
    private List<InstructionDetail> instructions;
    private String name;

    PartyEntity(int i, String str, String str2, String str3, List<InstructionDetail> list) {
        this.id = i;
        this.name = str;
        this.constituentName = str2;
        this.imageUrl = str3;
        this.instructions = list;
    }

    public static PartyEntity create(int i, String str, String str2, String str3, List<InstructionDetail> list) {
        return new PartyEntity(i, str, str2, str3, list);
    }

    public int getId() {
        return this.id;
    }

    /* access modifiers changed from: package-private */
    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getConstituentName() {
        return this.constituentName;
    }

    public void setConstituentName(String str) {
        this.constituentName = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public List<InstructionDetail> getInstructions() {
        return this.instructions;
    }

    public void setInstructions(List<InstructionDetail> list) {
        this.instructions = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PartyEntity partyEntity = (PartyEntity) obj;
        return this.id == partyEntity.id && this.name.equals(partyEntity.name) && this.constituentName.equals(partyEntity.constituentName) && this.imageUrl.equals(partyEntity.imageUrl);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.id), this.name, this.constituentName, this.imageUrl);
    }
}
