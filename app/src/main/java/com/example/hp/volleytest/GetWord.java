package com.example.hp.volleytest;

import java.util.List;

/**
 * Created by HP on 2015/10/16.
 */
public class GetWord {
    /**
     * msg : SUCCESS
     * status_code : 0
     * data : {"target_retention":5,"uk_audio":"http://media.shanbay.com/audio/uk/hello.mp3","pronunciation":"hә'lәu","en_definition":{"pos":"n","defn":"an expression of greeting"},"content":"hello","cn_definition":{"pos":"","defn":"int.（见面打招呼或打电话用语）喂,哈罗"},"us_audio":"http://media.shanbay.com/audio/us/hello.mp3","definition":" int.（见面打招呼或打电话用语）喂,哈罗","id":3130,"audio":"http://media.shanbay.com/audio/us/hello.mp3","en_definitions":{"n":["an expression of greeting"]},"learning_id":2915819690,"retention":4}
     */
    private String msg;
    private int status_code;
    private DataEntity data;

    public String toString(){
        if(status_code!=0)
            return "Query Failed.";
        else
            return data.toString();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatus_code() {
        return status_code;
    }

    public DataEntity getData() {
        return data;
    }

    public class DataEntity {
        /**
         * target_retention : 5
         * uk_audio : http://media.shanbay.com/audio/uk/hello.mp3
         * pronunciation : hә'lәu
         * en_definition : {"pos":"n","defn":"an expression of greeting"}
         * content : hello
         * cn_definition : {"pos":"","defn":"int.（见面打招呼或打电话用语）喂,哈罗"}
         * us_audio : http://media.shanbay.com/audio/us/hello.mp3
         * definition :  int.（见面打招呼或打电话用语）喂,哈罗
         * id : 3130
         * audio : http://media.shanbay.com/audio/us/hello.mp3
         * en_definitions : {"n":["an expression of greeting"]}
         * learning_id : 2915819690
         * retention : 4
         */
        private int target_retention;
        private String uk_audio;
        private String pronunciation;
        private En_definitionEntity en_definition;
        private String content;
        private Cn_definitionEntity cn_definition;
        private String us_audio;
        private String definition;
        private int id;
        private String audio;
        private En_definitionsEntity en_definitions;
        private String learning_id;
        private int retention;

        public String toString(){
            StringBuilder str = new StringBuilder();
            if((en_definitions!=null)&&(!en_definitions.toString().equals(""))) str.append("解释：" + en_definitions.toString() + "\n");
            if((en_definition!= null)&&(!en_definition.toString().equals(""))) str.append("英译：" + en_definition.toString() + "\n");
            if((cn_definition!=null)&&(!cn_definition.toString().equals(""))) str.append("中译：" + cn_definition.toString() + "\n");
            if((content!=null)&&(!content.toString().equals(""))) str.append("查询的单词：" + content + "\n\n");
            if((pronunciation!=null)&&(pronunciation.toString().equals(""))) str.append("音标：\\" + pronunciation + "\\\n");
            return str.toString();
        }

        public void setTarget_retention(int target_retention) {
            this.target_retention = target_retention;
        }

        public void setUk_audio(String uk_audio) {
            this.uk_audio = uk_audio;
        }

        public void setPronunciation(String pronunciation) {
            this.pronunciation = pronunciation;
        }

        public void setEn_definition(En_definitionEntity en_definition) {
            this.en_definition = en_definition;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCn_definition(Cn_definitionEntity cn_definition) {
            this.cn_definition = cn_definition;
        }

        public void setUs_audio(String us_audio) {
            this.us_audio = us_audio;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public void setEn_definitions(En_definitionsEntity en_definitions) {
            this.en_definitions = en_definitions;
        }

        public void setLearning_id(String learning_id) {
            this.learning_id = learning_id;
        }

        public void setRetention(int retention) {
            this.retention = retention;
        }

        public int getTarget_retention() {
            return target_retention;
        }

        public String getUk_audio() {
            return uk_audio;
        }

        public String getPronunciation() {
            return pronunciation;
        }

        public En_definitionEntity getEn_definition() {
            return en_definition;
        }

        public String getContent() {
            return content;
        }

        public Cn_definitionEntity getCn_definition() {
            return cn_definition;
        }

        public String getUs_audio() {
            return us_audio;
        }

        public String getDefinition() {
            return definition;
        }

        public int getId() {
            return id;
        }

        public String getAudio() {
            return audio;
        }

        public En_definitionsEntity getEn_definitions() {
            return en_definitions;
        }

        public String getLearning_id() {
            return learning_id;
        }

        public int getRetention() {
            return retention;
        }

        public class En_definitionEntity {
            /**
             * pos : n
             * defn : an expression of greeting
             */
            private String pos;
            private String defn;

            public String toString(){
                StringBuilder str = new StringBuilder();
                if(pos!=null) str.append(pos + " ");
                if(defn!=null) str.append(defn + "\n");
                return str.toString();
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public void setDefn(String defn) {
                this.defn = defn;
            }

            public String getPos() {
                return pos;
            }

            public String getDefn() {
                return defn;
            }
        }

        public class Cn_definitionEntity {
            /**
             * pos :
             * defn : int.（见面打招呼或打电话用语）喂,哈罗
             */
            private String pos;
            private String defn;

            public String toString(){
                StringBuilder str = new StringBuilder();
                if(pos!=null) str.append(pos/* + "\n"*/);
                if(defn!=null) str.append(defn + "\n");
                return str.toString();
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public void setDefn(String defn) {
                this.defn = defn;
            }

            public String getPos() {
                return pos;
            }

            public String getDefn() {
                return defn;
            }
        }

        public class En_definitionsEntity {
            /**
             * n : ["an expression of greeting"]
             */
            private List<String> n;

            public String toString(){
                if(n==null)
                    return null;
                else {
                    StringBuilder str = new StringBuilder();
                    for (int i = 1; i <= n.size(); i++) {
                        str.append(i + "." + n.get(i-1) + "\n");
                    }
                    return str.toString();
                }

            }

            public void setN(List<String> n) {
                this.n = n;
            }
            public List<String> getN() {
                return n;
            }
        }
    }
}
