class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String psu;
    private final String gpu;

    private Computer(ComputerBuilder builder) {
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.storage=builder.storage;
        this.psu=builder.psu;
        this.gpu=builder.gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getPsu() {
        return psu;
    }

    public String getGpu() {
        return gpu;
    }

    @Override
    public String toString() {
        return this.cpu+" : "+this.gpu+" : "+this.ram+" : "+this.storage+" : "+this.psu;
    }

    static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String storage;
        private String psu;
        private String gpu;
        public ComputerBuilder(){

        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setPsu(String psu) {
            this.psu = psu;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        public Computer build(){
            Computer comp=new Computer(this);
            return comp;
        }

    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Computer pc=new Computer.ComputerBuilder().setCpu("i9-14900H").setRam("64GB").setStorage("4TB").setPsu("1200W").setGpu("RTX 4090 12GB").build();
        System.out.println(pc);
    }
}
