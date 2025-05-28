import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class ProductWeb extends JFrame{
    private JLabel leftImage;
    private JTextArea leftTitle;
    private JLabel leftPrice;
    private JLabel leftBrand;
    private JTextArea leftDescription;
    private JPanel rightPanel;

    private List<Product> productList;
    private List<ProductCard> cardList = new ArrayList<>();

    public ProductWeb(){
        //Thông tin cửa sổ
        setTitle("Website Bán Sản Phẩm");
        setSize(1200, 700);
        setBackground(Color.WHITE);
        setMinimumSize(new Dimension(1200,700));
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Danh sách sản phẩm
        productList = Arrays.asList(
            new Product("4DFWD Pulse 'Core Black Signal Green'", "public/images/img1.png",160.00,"The midsole is created using 4D printing technology, providing flexibility, adaptability, and optimal support for every step.","Adidas"),
            new Product("Forum Mid Shoes", "public/images/img2.png",100.00,"Whether you're having a casual day out or stepping up your style for an evening downtown, these adidas shoes are your go-to classic with a modern edge. The mix of full grain and synthetic leathers combine heritage details with a sleek silhouette, giving you street-smart looks as timeless as the shoes themselves.","Adidas"),
            new Product("Runfalcon 5 Running Shoes", "public/images/img3.png",65.00,"From the track to the treadmill, run toward your goals in these running shoes from adidas. The cushy Cloudfoam midsole feels soft and supportive from the minute you step in. A breathable mesh upper and durable Adiwear outsole make these go-to trainers perfect for all-day wear.","Adidas"),
            new Product("4DFWD Pulse Running Shoes", "public/images/img4.png",160.00,"Harness the power of adidas 4D for a smoother run every time the rubber meets the road. These adidas 4DFWD Pulse Shoes have a 3D-printed heel cradle that's precisely angled to guide your foot forward on every step and absorb impact so every run feels easier.","Adidas"),
            new Product("4DFWD Pulse ‘Black Sonic Ink’", "public/images/img5.png",120.00,"3D printed midsole technology: The midsole of the shoe is created using adidas' proprietary structural mesh 3D printing technology, which helps absorb the force of impact, providing comfort and stability when running.","Adidas"),
            new Product("4DFWD Pulse Running Shoes", "public/images/img6.png",160.00,"Harness the power of adidas 4D for a smoother run every time the rubber meets the road. These adidas 4DFWD Pulse Shoes have a 3D-printed heel cradle that's precisely angled to guide your foot forward on every step and absorb impact so every run feels easier.","Adidas"),
            new Product("4DFWD Pulse 'Core Black Signal Green'", "public/images/img1.png",160.00,"The midsole is created using 4D printing technology, providing flexibility, adaptability, and optimal support for every step.","Adidas"),
            new Product("Forum Mid Shoes", "public/images/img2.png",100.00,"Whether you're having a casual day out or stepping up your style for an evening downtown, these adidas shoes are your go-to classic with a modern edge. The mix of full grain and synthetic leathers combine heritage details with a sleek silhouette, giving you street-smart looks as timeless as the shoes themselves.","Adidas"),
            new Product("Runfalcon 5 Running Shoes", "public/images/img3.png",65.00,"From the track to the treadmill, run toward your goals in these running shoes from adidas. The cushy Cloudfoam midsole feels soft and supportive from the minute you step in. A breathable mesh upper and durable Adiwear outsole make these go-to trainers perfect for all-day wear.","Adidas"),
            new Product("4DFWD Pulse Running Shoes", "public/images/img4.png",160.00,"Harness the power of adidas 4D for a smoother run every time the rubber meets the road. These adidas 4DFWD Pulse Shoes have a 3D-printed heel cradle that's precisely angled to guide your foot forward on every step and absorb impact so every run feels easier.","Adidas"),
            new Product("4DFWD Pulse ‘Black Sonic Ink’", "public/images/img5.png",120.00,"3D printed midsole technology: The midsole of the shoe is created using adidas' proprietary structural mesh 3D printing technology, which helps absorb the force of impact, providing comfort and stability when running.","Adidas"),
            new Product("4DFWD Pulse Running Shoes", "public/images/img6.png",160.00,"Harness the power of adidas 4D for a smoother run every time the rubber meets the road. These adidas 4DFWD Pulse Shoes have a 3D-printed heel cradle that's precisely angled to guide your foot forward on every step and absorb impact so every run feels easier.","Adidas")
        );

        //Khởi tạo các panel (trái và phải)
        JPanel leftPanel = initLeftPanel();
        JScrollPane rightScrollPane = initRightPanel(productList);
        //Dùng cardList để check isSelected
        if (!cardList.isEmpty()) {
            cardList.get(0).setSelected(true);
            updateLeftPanel(productList.get(0));
        }
        //Hiển thị sản phẩm đầu tiên
        updateLeftPanel(productList.get(0));

        //Dùng splitPane để chia đôi
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightScrollPane);
        splitPane.setResizeWeight(0.0); //không resize leftPanel
        splitPane.setDividerSize(0);    //bỏ devider
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(null);
        splitPane.setEnabled(false);

        add(splitPane);
        setVisible(true);

        //vị trí chia đôi
        SwingUtilities.invokeLater(() -> {
            splitPane.setDividerLocation(leftPanel.getPreferredSize().width);
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (rightPanel != null) {
                    rightPanel.revalidate();
                    rightPanel.repaint();   
                }
            }
        });
    }
    
    public JPanel initLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setPreferredSize(new Dimension(400, 0)); //size left Panel
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        leftImage = new JLabel("", SwingConstants.CENTER);    
        // Tạo panel chứa ảnh và cố định kích thước
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(leftImage, BorderLayout.CENTER);
        imagePanel.setPreferredSize(new Dimension(300, 300)); // size ảnh

        // Separator giữa ảnh và info
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(Color.LIGHT_GRAY);
        separator.setPreferredSize(new Dimension(1, 1)); // chiều cao mỏng

        // Panel chứa ảnh + separator
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(imagePanel, BorderLayout.NORTH);
        topPanel.add(separator, BorderLayout.SOUTH);
    
        // Panel chứa info
        JPanel leftInfo = new JPanel();
        leftInfo.setLayout(new BoxLayout(leftInfo, BoxLayout.Y_AXIS));
        leftInfo.setBackground(Color.WHITE);
        leftInfo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // padding ngoài

        leftTitle = new JTextArea();
        leftTitle.setFont(new Font("Arial", Font.BOLD, 30));
        leftTitle.setLineWrap(true);       
        leftTitle.setWrapStyleWord(true);  
        leftTitle.setEditable(false);  
        leftTitle.setOpaque(false);   
        leftTitle.setFocusable(false); 
        leftTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, 3 * 36));    //tối đa 3 dòng, lineHeight = 36
        leftTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // padding dưới

        leftBrand = new JLabel("", SwingConstants.LEFT);
        leftBrand.setFont(new Font("Arial", Font.PLAIN, 18));
        leftBrand.setAlignmentX(Component.LEFT_ALIGNMENT); 
        leftBrand.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        leftPrice = new JLabel("", SwingConstants.LEFT);
        leftPrice.setFont(new Font("Arial", Font.BOLD, 24));
        leftPrice.setAlignmentX(Component.LEFT_ALIGNMENT); 
        leftPrice.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        leftDescription = new JTextArea();
        leftDescription.setFont(new Font("Arial", Font.BOLD, 18));
        leftDescription.setLineWrap(true);       
        leftDescription.setWrapStyleWord(true);  
        leftDescription.setEditable(false);  
        leftDescription.setOpaque(false);   
        leftDescription.setFocusable(false); 
        leftDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        leftDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftInfo.add(leftTitle);
        leftInfo.add(leftBrand);
        leftInfo.add(leftPrice);
        leftInfo.add(leftDescription);

        // Ghép tất cả lại
        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(leftInfo, BorderLayout.CENTER); 
    
        return leftPanel;
    }    
    
    public JScrollPane initRightPanel(List<Product> productList) {
        rightPanel = new JPanel(new WrapLayout(FlowLayout.LEFT, 20, 20));
        rightPanel.setBackground(Color.WHITE);
    
        cardList.clear();  // dọn sạch nếu có
    
        for (Product p : productList) {
            ProductCard card = new ProductCard(p);
            card.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    // Bỏ chọn tất cả card
                    for (ProductCard c : cardList) {
                        c.setSelected(false);
                    }
                    // Chọn card hiện tại
                    card.setSelected(true);
                    // Cập nhật left panel
                    updateLeftPanel(p);
                }
            });
    
            cardList.add(card);
            rightPanel.add(card);
        }
    
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(rightPanel);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }    

    public void updateLeftPanel(Product product){
        ImageIcon icon = new ImageIcon(product.getImagePath());
        Image scaled = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        leftImage.setIcon(new ImageIcon(scaled));
        leftTitle.setText(product.getName());
        leftDescription.setText(product.getDesciption());         
        leftBrand.setText(product.getBrand());
        leftPrice.setText("$" + product.getPrice());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductWeb::new);
    }
}
