public class Park {
    private String location;
    private String id;

    public Park(String id, String location) {
        this.id = id;
        this.location = location;
    }

    public class AttractionInfo {
        private String atractionName;
        private String workingTime;
        private double cost;

        public AttractionInfo(String atractionName, String workingTime, double cost) {
            this.atractionName = atractionName;
            this.workingTime = workingTime;
            this.cost = cost;
        }

        void showAttractionInfo() {
            System.out.println("[Park id: " + Park.this.id + ". Location: " + Park.this.location + "]" +
                    "\n*******************************" +
                    "\nName: " + atractionName + "\nWorking Time: " + workingTime + "\nCost: " + cost +
                    "\n*******************************\n\n");
        }
    }
}