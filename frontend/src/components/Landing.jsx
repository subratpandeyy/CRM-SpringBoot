import { useState } from 'react';
import { Users, BarChart3, Zap, Shield, TrendingUp, CheckCircle, Menu, X, ArrowRight } from 'lucide-react';
import logo from "../assets/logo.png";

const Landing = () => {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);

  const features = [
    {
      icon: <Users className="w-8 h-8" />,
      title: 'Contact Management',
      description: 'Centralize all customer data in one place. Track interactions, manage relationships, and never miss a follow-up.'
    },
    {
      icon: <TrendingUp className="w-8 h-8" />,
      title: 'Sales Pipeline',
      description: 'Visualize your sales process from lead to close. Track deals, forecast revenue, and optimize conversion rates.'
    },
    {
      icon: <BarChart3 className="w-8 h-8" />,
      title: 'Advanced Analytics',
      description: 'Get actionable insights with real-time dashboards. Make data-driven decisions to grow your business faster.'
    },
    {
      icon: <Zap className="w-8 h-8" />,
      title: 'Workflow Automation',
      description: 'Automate repetitive tasks and focus on what matters. Set up custom triggers, notifications, and follow-ups.'
    },
    {
      icon: <Shield className="w-8 h-8" />,
      title: 'Security & Compliance',
      description: 'Enterprise-grade security with data encryption, role-based access, and compliance with industry standards.'
    },
    {
      icon: <CheckCircle className="w-8 h-8" />,
      title: 'Task Management',
      description: 'Organize team activities, assign tasks, set deadlines, and track progress all within your CRM workspace.'
    }
  ];

  const handleRoute = () => {
    window.location.href="/login";
  }

  const handleTrial = () => {
    window.location.href = "/register";
  }

  const stats = [
    { value: '10,000+', label: 'Active Users' },
    { value: '98%', label: 'Customer Satisfaction' },
    { value: '2.5x', label: 'Revenue Growth' },
    { value: '24/7', label: 'Support Available' }
  ];

  const benefits = [
    'Increase sales productivity by 40%',
    'Reduce data entry time by 60%',
    'Improve customer retention rates',
    'Scale your business efficiently',
    'Seamless team collaboration',
    'Mobile access anywhere, anytime'
  ];

  return (
    <div className="w-full font-['Inter',sans-serif]">
      {/* Navigation */}
      <nav className="sticky top-0 bg-white/95 backdrop-blur-md border-b border-gray-200 z-50 py-4" data-testid="main-navigation">
        <div className="max-w-7xl mx-auto px-8 flex justify-between items-center">
          <div className="flex items-center gap-3 cursor-pointer" data-testid="nav-logo">
          <img src={logo} className='h-8 w-8 mr-2' />
            <span className="font-['Space_Grotesk',sans-serif] text-2xl font-bold text-[#004E92]">CRUXCRM</span>
          </div>
          
          <div className="hidden md:flex items-center gap-8">
            <a href="#features" className="text-gray-600 hover:text-[#004E92] font-medium text-[15px] transition-colors" data-testid="nav-features-link">Features</a>
            <a href="#benefits" className="text-gray-600 hover:text-[#004E92] font-medium text-[15px] transition-colors" data-testid="nav-benefits-link">Benefits</a>
            <button className="bg-[#004E92] text-white px-6 py-2.5 rounded-lg font-semibold text-[15px] hover:bg-[#003d75] hover:-translate-y-0.5 transition-all" data-testid="nav-cta-button"
                onClick={handleRoute}
            >
              Get Started
            </button>
          </div>

          <button 
            className="md:hidden text-[#004E92]"
            onClick={() => setMobileMenuOpen(!mobileMenuOpen)}
            data-testid="mobile-menu-button"
          >
            {mobileMenuOpen ? <X className="w-6 h-6" /> : <Menu className="w-6 h-6" />}
          </button>
        </div>

        {mobileMenuOpen && (
          <div className="md:hidden flex flex-col gap-4 px-8 py-4 bg-white border-t border-gray-200" data-testid="mobile-menu">
            <a href="#features" onClick={() => setMobileMenuOpen(false)} className="text-gray-600 font-medium py-2">Features</a>
            <a href="#benefits" onClick={() => setMobileMenuOpen(false)} className="text-gray-600 font-medium py-2">Benefits</a>
            <button className="bg-[#004E92] text-white px-6 py-2.5 rounded-lg font-semibold hover:bg-[#003d75] transition-colors" data-testid="mobile-cta-button">
              Get Started
            </button>
          </div>
        )}
      </nav>

      {/* Hero Section */}
      <section className="max-w-7xl mx-auto px-8 py-20 grid md:grid-cols-2 gap-16 items-center" data-testid="hero-section">
        <div className="flex flex-col gap-6">
          <h1 className="font-['Space_Grotesk',sans-serif] text-5xl md:text-6xl lg:text-7xl font-bold text-gray-900 leading-tight" data-testid="hero-title">
            Transform Your Customer Relationships
          </h1>
          <p className="text-lg text-gray-600 leading-relaxed" data-testid="hero-subtitle">
            The all-in-one CRM platform that helps businesses build stronger relationships,
            close more deals, and accelerate growth. Trusted by thousands of companies worldwide.
          </p>
          <div className="flex flex-col sm:flex-row gap-4 mt-4">
            <button className="bg-[#004E92] text-white px-8 py-4 rounded-xl font-semibold text-base flex items-center justify-center hover:bg-[#003d75] hover:-translate-y-0.5 transition-all" data-testid="hero-primary-cta"
                onClick={handleTrial}
            >
              Start Free Trial
              <ArrowRight className="w-5 h-5 ml-2" />
            </button>
          </div>
        </div>
        
        <div className="relative rounded-2xl overflow-hidden shadow-[0_20px_60px_rgba(0,78,146,0.15)]" data-testid="hero-image">
          <img 
            src="https://images.unsplash.com/photo-1551434678-e076c223a692?q=80&w=2070" 
            alt="CRM Dashboard Preview"
            className="w-full h-auto"
          />
        </div>
      </section>

      {/* Stats Section */}
      <section className="bg-gray-50 py-12" data-testid="stats-section">
        <div className="max-w-7xl mx-auto px-8 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8">
          {stats.map((stat, index) => (
            <div key={index} className="text-center" data-testid={`stat-card-${index}`}>
              <div className="font-['Space_Grotesk',sans-serif] text-4xl lg:text-5xl font-bold text-[#004E92] mb-2" data-testid={`stat-value-${index}`}>
                {stat.value}
              </div>
              <div className="text-[15px] text-gray-600 font-medium" data-testid={`stat-label-${index}`}>
                {stat.label}
              </div>
            </div>
          ))}
        </div>
      </section>

      {/* Features Section */}
      <section id="features" className="max-w-7xl mx-auto px-8 py-20" data-testid="features-section">
        <div className="text-center mb-16">
          <h2 className="font-['Space_Grotesk',sans-serif] text-4xl lg:text-5xl font-bold text-gray-900 mb-4" data-testid="features-title">
            Powerful Features for Modern Teams
          </h2>
          <p className="text-lg text-gray-600 max-w-2xl mx-auto" data-testid="features-subtitle">
            Everything you need to manage customer relationships and grow your business
          </p>
        </div>
        
        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8">
          {features.map((feature, index) => (
            <div key={index} className="bg-white border border-gray-200 rounded-xl p-8 hover:shadow-[0_12px_40px_rgba(0,78,146,0.12)] hover:-translate-y-1 transition-all" data-testid={`feature-card-${index}`}>
              <div className="w-14 h-14 bg-[#e8f4ff] rounded-xl flex items-center justify-center text-[#004E92] mb-5" data-testid={`feature-icon-${index}`}>
                {feature.icon}
              </div>
              <h3 className="font-['Space_Grotesk',sans-serif] text-xl font-semibold text-gray-900 mb-3" data-testid={`feature-title-${index}`}>
                {feature.title}
              </h3>
              <p className="text-[15px] text-gray-600 leading-relaxed" data-testid={`feature-description-${index}`}>
                {feature.description}
              </p>
            </div>
          ))}
        </div>
      </section>

      {/* Benefits Section */}
      <section id="benefits" className="bg-gray-50 py-20" data-testid="benefits-section">
        <div className="max-w-7xl mx-auto px-8 grid md:grid-cols-2 gap-16 items-center">
          <div className="flex flex-col gap-6">
            <h2 className="font-['Space_Grotesk',sans-serif] text-4xl lg:text-5xl font-bold text-gray-900" data-testid="benefits-title">
              Why Leading Companies Choose ProCRM
            </h2>
            <p className="text-lg text-gray-600 leading-relaxed" data-testid="benefits-intro">
              Join thousands of businesses that have transformed their sales process and customer relationships.
            </p>
            <div className="flex flex-col gap-4 mt-4">
              {benefits.map((benefit, index) => (
                <div key={index} className="flex items-center gap-3 text-base text-gray-700" data-testid={`benefit-item-${index}`}>
                  <CheckCircle className="w-6 h-6 text-[#004E92] flex-shrink-0" />
                  <span>{benefit}</span>
                </div>
              ))}
            </div>
          </div>
          <div className="relative rounded-2xl overflow-hidden shadow-[0_20px_60px_rgba(0,78,146,0.15)]" data-testid="benefits-image">
            <img 
              src="https://images.unsplash.com/photo-1460925895917-afdab827c52f?q=80&w=2015" 
              alt="Business Growth Analytics"
              className="w-full h-auto"
            />
          </div>
        </div>
      </section>

      {/* CTA Section */}
      <section className="max-w-7xl mx-auto px-8 py-20" data-testid="cta-section">
        <div className="bg-gradient-to-br from-[#004E92] to-[#0066b8] rounded-3xl p-16 text-center text-white">
          <h2 className="font-['Space_Grotesk',sans-serif] text-4xl lg:text-5xl font-bold mb-4" data-testid="cta-title">
            Ready to Transform Your Business?
          </h2>
          <p className="text-lg mb-8 opacity-95" data-testid="cta-subtitle">
            Start your 14-day free trial today. No credit card required.
          </p>
          <button className="bg-white text-[#004E92] px-10 py-4 rounded-xl font-semibold text-base inline-flex items-center hover:-translate-y-0.5 hover:shadow-[0_8px_24px_rgba(0,78,146,0.3)] transition-all" data-testid="final-cta-button"
            onClick={handleTrial}
        >
            Get Started Now
            <ArrowRight className="w-5 h-5 ml-2" />
          </button>
        </div>
      </section>

      {/* Footer */}
      <footer className="bg-gray-900 text-white py-12 px-8" data-testid="footer">
        <div className="max-w-7xl mx-auto grid md:grid-cols-[2fr_3fr] gap-16 mb-8">
          <div className="flex flex-col gap-4">
            <div className="flex items-center gap-3">
              
              <span className="font-['Space_Grotesk',sans-serif] text-2xl font-bold text-white">CRUXCRM</span>
            </div>
            <p className="text-gray-400 text-[15px] leading-relaxed">
            Simplify Customer Success.
            </p>
          </div>
          <div className="grid grid-cols-1 sm:grid-cols-3 gap-8">
            <div className="flex flex-col gap-3">
              <h4 className="font-['Space_Grotesk',sans-serif] text-base font-semibold mb-2">Product</h4>
              <a href="#features" className="text-gray-400 text-[15px] hover:text-white transition-colors">Features</a>
              <a href="#pricing" className="text-gray-400 text-[15px] hover:text-white transition-colors">Pricing</a>
              <a href="#integrations" className="text-gray-400 text-[15px] hover:text-white transition-colors">Integrations</a>
            </div>
            <div className="flex flex-col gap-3">
              <h4 className="font-['Space_Grotesk',sans-serif] text-base font-semibold mb-2">Company</h4>
              <a href="#about" className="text-gray-400 text-[15px] hover:text-white transition-colors">About Us</a>
              <a href="#careers" className="text-gray-400 text-[15px] hover:text-white transition-colors">Careers</a>
              <a href="#contact" className="text-gray-400 text-[15px] hover:text-white transition-colors">Contact</a>
            </div>
            <div className="flex flex-col gap-3">
              <h4 className="font-['Space_Grotesk',sans-serif] text-base font-semibold mb-2">Resources</h4>
              <a href="#docs" className="text-gray-400 text-[15px] hover:text-white transition-colors">Documentation</a>
              <a href="#support" className="text-gray-400 text-[15px] hover:text-white transition-colors">Support</a>
              <a href="#blog" className="text-gray-400 text-[15px] hover:text-white transition-colors">Blog</a>
            </div>
          </div>
        </div>
        <div className="max-w-7xl mx-auto pt-8 border-t border-gray-700 text-center text-gray-400 text-sm">
          <p>&copy; 2025 CRUXCRM. All rights reserved.</p>
        </div>
      </footer>
    </div>
  );
};

export default Landing;