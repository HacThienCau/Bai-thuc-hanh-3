import java.awt.*;
import javax.swing.*;

public class ProductCard extends JPanel {
    private Product product;
    private boolean selected = false;

    public ProductCard(Product product) {
        this.product = product;
        setOpaque(false);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, 300));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding 10

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);

        // Tên sản phẩm (bold 20, center)
        JLabel nameLabel = new JLabel(product.getName(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mô tả (plain 16, center)
        JLabel descriptionLabel = new JLabel(product.getDesciption(), SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionLabel.setMaximumSize(new Dimension(230, 30));
        descriptionLabel.setPreferredSize(new Dimension(230, 30));
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Hình ảnh (200x200)
        JLabel imageLabel = new JLabel();
        ImageIcon icon = new ImageIcon(product.getImagePath());
        Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaled));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Brand (left) + Price (right)
        JPanel brandPricePanel = new JPanel(new BorderLayout());
        brandPricePanel.setOpaque(false);

        JLabel brandLabel = new JLabel(product.getBrand());
        brandLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel priceLabel = new JLabel("$" + String.format("%.2f", product.getPrice()));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        priceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        brandPricePanel.add(brandLabel, BorderLayout.WEST);
        brandPricePanel.add(priceLabel, BorderLayout.EAST);

        // Add components
        contentPanel.add(nameLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(descriptionLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(imageLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(brandPricePanel);

        add(contentPanel, BorderLayout.CENTER);
    }

    public Product getProduct() {
        return product;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int arc = 20;
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color bgColor = new Color(243, 236, 237);
        Color borderColor = selected ? Color.BLUE : bgColor;
        float strokeWidth = selected ? 2f : 0f; //selected thì viền dày 2, ngược lại 0

        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        if (strokeWidth > 0f) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(strokeWidth));
            g2.drawRoundRect((int)(strokeWidth / 2), (int)(strokeWidth / 2),
                    getWidth() - (int)strokeWidth, getHeight() - (int)strokeWidth,
                    arc, arc);
        }

        g2.dispose();
        super.paintComponent(g);
    }
}
